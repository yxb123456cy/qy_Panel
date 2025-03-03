package org.qy.panel.service;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.qy.panel.config.AuthKeyConfig;
import org.qy.panel.entity.Response;
import org.qy.panel.entity.dto.Client;
import org.qy.panel.entity.vo.request.ClientDetailVO;
import org.qy.panel.tools.Const;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientService {
    private final AuthKeyConfig authKeyConfig;
    private final RedisTemplate<String, Object> redisTemplate;
    private String authToken;

    private boolean checkTokenCache(String authToken) {
        Object object = redisTemplate.boundValueOps(Const.CACHE_PREFIX + ":authToken:" + authToken)
                .get();
        return ObjectUtil.isNotNull(object);
    }

    private String getClientIDFromCache(String authToken) {
        return (String) redisTemplate.boundValueOps(Const.CACHE_PREFIX + ":authToken:" + authToken).get();
    }

    private void saveClientInfoToCache(String clientID, String authToken) {
        Client client = new Client();
        client.setId(clientID).setName("未命名主机").setNode("默认节点")
                .setToken(authToken)
                .setLocation("中国")
                .setRegisterTime(new Date());
        redisTemplate.boundHashOps(Const.CACHE_PREFIX + "client")
                .put(clientID, client);
    }

    //保存authKey与clientID的关系;
    private void saveAuthKeyWithClientID(String authToken, String clientID) {
        redisTemplate.boundValueOps(Const.CACHE_PREFIX + ":authToken:" + authToken)
                .set(clientID);
    }

    private void saveClientDetailToCache(String clientID, ClientDetailVO clientDetailVO) {
        //保存clientDetail;
        redisTemplate.boundHashOps(Const.CACHE_PREFIX + "clientDetail")
                .put(clientID, clientDetailVO);
    }


    //保存ClientID
    public Response<Boolean> saveClientDetail(String authToken, ClientDetailVO clientDetailVO) {
        //authToken从请求头中获取;
        //校验是否存在;
        boolean checked = this.checkTokenCache(authToken);
        if (!checked) {
            //不存在;
            log.error("authToken为:{}的主机未进行注册", authToken);
            return Response.fail("未注册,请先注册主机!");
        }
        //存在;
        String clientID = this.getClientIDFromCache(authToken);
        this.saveClientDetailToCache(clientID, clientDetailVO);
        return Response.success(true);
    }

    @PostConstruct
    public void genToken() {
        String asHex = DigestUtils.md5DigestAsHex(("panel-fjx").getBytes(StandardCharsets.UTF_8));
        this.authToken = IdUtil.fastUUID() + asHex;
    }

    public String getCurrentToken() {
        log.info("获取当前注册所需Token:{}", authToken);
        return authToken;
    }

    //monitor注册;
    public Response<Boolean> register(String authKey) {
        if (StrUtil.isBlank(authKey) || StrUtil.isEmpty(authKey)) {
            return Response.fail("authKey不能为空");
        }
        if (authKey.equals(getCurrentToken())) {
            //注册成功;
            //保存Client至Redis;
            //保存authToken与clientID的关系;
            String clientID = IdUtil.getSnowflakeNextIdStr(); //保存client与Token;
            CompletableFuture.runAsync(() -> {
                this.saveClientInfoToCache(clientID, authKey);
            }).join();
            CompletableFuture.runAsync(() -> {
                this.saveAuthKeyWithClientID(authKey, clientID);
            }).join();
            log.info("注册成功");
            return Response.success(true);
        }
        log.error("authKey错误,请联系管理员重新获取");
        return Response.fail("authKey错误,请联系管理员重新获取");
    }
}

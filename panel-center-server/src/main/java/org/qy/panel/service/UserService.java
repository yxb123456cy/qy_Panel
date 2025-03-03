package org.qy.panel.service;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.stream.CollectorUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.qy.panel.entity.Response;
import org.qy.panel.entity.dto.Account;
import org.qy.panel.entity.vo.request.ChangePasswordVO;
import org.qy.panel.entity.vo.request.CreateSubAccountVO;
import org.qy.panel.entity.vo.request.ModifyEmailVO;
import org.qy.panel.entity.vo.response.SubAccountVO;
import org.qy.panel.tools.Const;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final RedisTemplate<String, Object> redisTemplate;

    /**
     * 保存面板子用户信息;
     */
    private void registerCommonAccount(CreateSubAccountVO vo) {
        Account account = new Account();
        long snowflakeNextId = IdUtil.getSnowflakeNextId();
        account.setId(snowflakeNextId).setEmail(vo.getEmail()).setUsername(vo.getUsername()).setPassword(vo.getPassword()).setClients("1").setRole("common").setRegisterTime(new Date());
        redisTemplate.opsForHash().put(Const.CACHE_PREFIX + "account", String.valueOf(snowflakeNextId), JSON.toJSONString(account));
    }

    @PostConstruct
    //初始化一个admin账号;
    private void initAdminAccount() {
        Account account = new Account();
        long snowflakeNextId = 1896537494959697920L;
        account.setId(snowflakeNextId).setRole("admin").setEmail("218625671@qq.com").setClients("").setUsername("轻叶-管理员").setPassword(DigestUtils.md5DigestAsHex(("123456").getBytes(StandardCharsets.UTF_8))).setRegisterTime(new Date());
        redisTemplate.opsForHash().put(Const.CACHE_PREFIX + "account", String.valueOf(snowflakeNextId), JSON.toJSONString(account));

    }

    /**
     * 修改密码 权限为admin与common 不进行鉴权;
     * @param vo vo
     * @return Response<Void>
     */
    public Response<Void> changePassword(@RequestBody @Valid ChangePasswordVO vo) {
        //从token中获取UserId;
        String loginId = (String) StpUtil.getLoginId();
        //两次密码判断是否相等;
        if (!vo.getPassword().equals(vo.getNew_password())) {
            throw new RuntimeException("两次密码不相等");
        }
        //从Redis中查询并进行修改;
        Object object = redisTemplate.opsForHash().get(Const.CACHE_PREFIX + "account", loginId);
        Account account = JSON.parseObject(JSON.toJSONString(object), Account.class);
        account.setPassword(vo.getNew_password());
        redisTemplate.opsForHash().put(Const.CACHE_PREFIX + "account", (loginId), JSON.toJSONString(account));
        return Response.success();
    }

    /**
     * 修改邮箱 权限为admin与common 不进行鉴权;
     * @param vo ModifyEmailVO
     * @return Response<Void>
     */

    public Response<Void> modifyEmail(@RequestBody @Valid ModifyEmailVO vo) {
        //判断验证码;
        //saToken获取UserId;
        //从缓存中查询value并进行修改邮箱;
        return null;
    }

    /**
     * 创建面板子用户 需要权限为admin 需要进行鉴权;
     * @param vo CreateSubAccountVO
     * @return Response<Void>
     */
    public Response<Void> createSubAccount(@RequestBody @Valid CreateSubAccountVO vo) {
        boolean hasAdminRole = StpUtil.hasRole("admin");
        if (!hasAdminRole) {
            throw new RuntimeException("权限错误");
        }
        //具有Admin权限;
        this.registerCommonAccount(vo);
        return Response.success();
    }

    /**
     * 删除子用户 需要权限为admin 需要进行鉴权
     * @param uid 面板子用户ID
     * @return Response<Void>
     */
    public Response<Void> deleteSubAccount(long uid) {
        boolean hasAdminRole = StpUtil.hasRole("admin");
        if (!hasAdminRole) {
            throw new RuntimeException("权限错误");
        }
        //删除;
        Long deleted = redisTemplate.opsForHash().delete(Const.CACHE_PREFIX + "account", String.valueOf(uid));
        if (!(deleted > 0)) {
            throw new RuntimeException("删除失败,服务端错误 deleteID:" + uid);
        } else {
            return Response.success();
        }
    }

    /**
     * 获取面板子用户列表 需要权限为admin 需要进行鉴权
     * @return Response<List < SubAccountVO>>
     */
    public Response<List<SubAccountVO>> subAccountList() {
        boolean hasAdminRole = StpUtil.hasRole("admin");
        if (!hasAdminRole) {
            throw new RuntimeException("权限错误");
        }
        Map<Object, Object> entries = redisTemplate.boundHashOps(Const.CACHE_PREFIX + "account").entries();
        if (entries != null) {
            Collection<Object> values = entries.values();
            List<Object> list = values.stream().toList();
            List<SubAccountVO> subAccountVOList = new ArrayList<>();
            /* BeanUtil.copyToList(list, Account.class);*/
            for (Object object : list) {
                Account account = JSON.parseObject(JSON.toJSONString(object), Account.class);
                if (account.getRole().equals("common")) {
                    //加入;
                    SubAccountVO vo = new SubAccountVO();
                    BeanUtils.copyProperties(account, vo);
                    subAccountVOList.add(vo);
                }
            }
            return Response.success(subAccountVOList);
        } else {
            throw new RuntimeException("获取子面板用户列表失败,服务端错误");
        }
    }
}

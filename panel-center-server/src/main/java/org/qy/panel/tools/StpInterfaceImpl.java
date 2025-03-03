package org.qy.panel.tools;

import cn.dev33.satoken.stp.StpInterface;
import com.alibaba.fastjson2.JSON;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.qy.panel.entity.dto.Account;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StpInterfaceImpl implements StpInterface {
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public List<String> getPermissionList(Object o, String s) {
        return List.of();
    }

    //获取角色标识集合;
    @Override
    public List<String> getRoleList(Object loginId, String s) {
        String userID = (String) loginId;
        Object object = redisTemplate.opsForHash()
                .get(Const.CACHE_PREFIX + "account", userID);
        Account account = JSON.parseObject(JSON.toJSONString(object), Account.class);
        return List.of(account.getRole());
    }
}

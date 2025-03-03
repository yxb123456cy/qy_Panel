package org.qy.panel.entity.vo.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 登录验证成功的用户信息响应
 */
@Data
public class AuthorizeVO implements Serializable {
    private  String username;
    private  String email;
    private  String role;
    private  String token;
    private  Date expire;

    @Serial
    private static final long serialVersionUID = 1L;
}

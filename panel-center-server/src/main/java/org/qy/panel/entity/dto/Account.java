package org.qy.panel.entity.dto;

import com.alibaba.fastjson2.JSONArray;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 数据库中的用户信息
 */
@Data
@Accessors(chain = true)
public class Account implements Serializable {
    Integer id;
    String username;
    String password;
    String email;
    String role;
    Date registerTime;
    String clients;

    public List<Integer> getClientList() {
        if (clients == null) return Collections.emptyList();
        return JSONArray.parse(clients).toList(Integer.class);
    }

    @Serial
    private static final long serialVersionUID = 1L;
}

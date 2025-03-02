package org.qy.panel.entity.vo.response;

import com.alibaba.fastjson2.JSONArray;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class SubAccountVO implements Serializable {
    int id;
    String username;
    String email;
    JSONArray clientList;

    @Serial
    private static final long serialVersionUID = 1L;
}

package org.qy.panel.entity.vo.response;

import com.alibaba.fastjson2.JSONObject;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Data
public class RuntimeHistoryVO implements Serializable {
    double disk;
    double memory;
    List<JSONObject> list = new LinkedList<>();

    @Serial
    private static final long serialVersionUID = 1L;
}

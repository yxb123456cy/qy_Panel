package org.qy.panel.entity.vo.response;

import com.alibaba.fastjson2.JSONObject;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Data
public class RuntimeHistoryVO implements Serializable {
    private double disk;
    private double memory;
    private List<JSONObject> list = new LinkedList<>();

    @Serial
    private static final long serialVersionUID = 1L;
}

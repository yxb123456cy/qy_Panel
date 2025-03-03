package org.qy.panel.entity.vo.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ClientSimpleVO implements Serializable {
    private  int id;
    private  String name;
    private  String location;
    private  String osName;
    private String osVersion;
    private String ip;

    @Serial
    private static final long serialVersionUID = 1L;
}

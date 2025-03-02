package org.qy.panel.entity.vo.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ClientSimpleVO implements Serializable {
    int id;
    String name;
    String location;
    String osName;
    String osVersion;
    String ip;

    @Serial
    private static final long serialVersionUID = 1L;
}

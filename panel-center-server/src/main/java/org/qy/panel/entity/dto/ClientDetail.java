package org.qy.panel.entity.dto;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ClientDetail implements Serializable {

    Integer id;
    String osArch;
    String osName;
    String osVersion;
    int osBit;
    String cpuName;
    int cpuCore;
    double memory;
    double disk;
    String ip;

    @Serial
    private static final long serialVersionUID = 1L;
}

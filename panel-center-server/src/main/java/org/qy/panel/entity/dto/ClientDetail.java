package org.qy.panel.entity.dto;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ClientDetail implements Serializable {

    private  Integer id;
    private  String osArch;
    private  String osName;
    private  String osVersion;
    private  int osBit;
    private  String cpuName;
    private  int cpuCore;
    private   double memory;
    private  double disk;
    private  String ip;

    @Serial
    private static final long serialVersionUID = 1L;
}

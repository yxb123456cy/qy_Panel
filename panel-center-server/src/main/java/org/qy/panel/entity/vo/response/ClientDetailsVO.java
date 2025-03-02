package org.qy.panel.entity.vo.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ClientDetailsVO implements Serializable {
    int id;
    String name;
    boolean online;
    String node;
    String location;
    String ip;
    String cpuName;
    String osName;
    String osVersion;
    double memory;
    int cpuCore;
    double disk;

    @Serial
    private static final long serialVersionUID = 1L;
}

package org.qy.panel.entity.vo.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ClientDetailsVO implements Serializable {
    private  int id;
    private  String name;
    private   boolean online;
    private   String node;
    private   String location;
    private   String ip;
    private  String cpuName;
    private  String osName;
    private  String osVersion;
    private  double memory;
    private   int cpuCore;
    private   double disk;

    @Serial
    private static final long serialVersionUID = 1L;
}

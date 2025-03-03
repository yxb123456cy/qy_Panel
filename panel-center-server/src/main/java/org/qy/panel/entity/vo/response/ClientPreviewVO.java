package org.qy.panel.entity.vo.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ClientPreviewVO implements Serializable {
    private  int id;
    private   boolean online;
    private   String name;
    private   String location;
    private   String osName;
    private  String osVersion;
    private  String ip;
    private  String cpuName;
    private  int cpuCore;
    private  double memory;
    private  double cpuUsage;
    private  double memoryUsage;
    private double networkUpload;
    private double networkDownload;

    @Serial
    private static final long serialVersionUID = 1L;
}

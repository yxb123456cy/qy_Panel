package org.qy.panel.entity.vo.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ClientPreviewVO implements Serializable {
    int id;
    boolean online;
    String name;
    String location;
    String osName;
    String osVersion;
    String ip;
    String cpuName;
    int cpuCore;
    double memory;
    double cpuUsage;
    double memoryUsage;
    double networkUpload;
    double networkDownload;

    @Serial
    private static final long serialVersionUID = 1L;
}

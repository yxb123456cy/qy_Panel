package org.qy.panel.entity.vo.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ClientDetailVO implements Serializable {
    @NotNull
    private  String osArch;
    @NotNull
    private  String osName;
    @NotNull
    private  String osVersion;
    @NotNull
    private  int osBit;
    @NotNull
    private  String cpuName;
    @NotNull
    private  int cpuCore;
    @NotNull
    private   double memory;
    @NotNull
    private   double disk;
    @NotNull
    private   String ip;

    @Serial
    private static final long serialVersionUID = 1L;
}

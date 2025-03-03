package org.qy.panel.entity.vo.request;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class RuntimeDetailVO implements Serializable {
    @NotNull
    private   long timestamp;
    @NotNull
    private   double cpuUsage;
    @NotNull
    private   double memoryUsage;
    @NotNull
    private   double diskUsage;
    @NotNull
    private  double networkUpload;
    @NotNull
    private   double networkDownload;
    @NotNull
    private    double diskRead;
    @NotNull
    private   double diskWrite;

    @Serial
    private static final long serialVersionUID = 1L;
}

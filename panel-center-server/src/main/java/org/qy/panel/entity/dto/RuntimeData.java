package org.qy.panel.entity.dto;

import com.influxdb.annotations.Column;
import com.influxdb.annotations.Measurement;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
@Accessors(chain = true)
@Data
@Measurement(name = "runtime")
public class RuntimeData implements Serializable {
    @Column(tag = true)
    private   int clientId;
    @Column(timestamp = true)
    private  Instant timestamp;
    @Column
    private  double cpuUsage;
    @Column
    private  double memoryUsage;
    @Column
    private   double diskUsage;
    @Column
    private  double networkUpload;
    @Column
    private  double networkDownload;
    @Column
    private   double diskRead;
    @Column
    private   double diskWrite;

    @Serial
    private static final long serialVersionUID = 1L;
}

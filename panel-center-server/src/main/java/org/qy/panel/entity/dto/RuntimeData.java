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
    int clientId;
    @Column(timestamp = true)
    Instant timestamp;
    @Column
    double cpuUsage;
    @Column
    double memoryUsage;
    @Column
    double diskUsage;
    @Column
    double networkUpload;
    @Column
    double networkDownload;
    @Column
    double diskRead;
    @Column
    double diskWrite;

    @Serial
    private static final long serialVersionUID = 1L;
}

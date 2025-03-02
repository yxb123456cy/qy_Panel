package org.qy.panel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class ConnectionConfig implements Serializable {
    /**
     * 中央服务地址
     */
    private String address;
    /**
     * 注册机器时候所需的密钥;
     */
    private String authKey;
    /**
     * 所选网卡;
     */
    private String networkInterface;

    @Serial
    private static final long serialVersionUID = 1L;
}

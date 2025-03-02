package org.qy.panel.entity.vo.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class SshSettingsVO implements Serializable {
    String ip;
    int port = 22;
    String username;
    String password;

    @Serial
    private static final long serialVersionUID = 1L;
}

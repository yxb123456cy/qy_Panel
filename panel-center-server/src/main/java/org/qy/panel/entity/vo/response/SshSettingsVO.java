package org.qy.panel.entity.vo.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class SshSettingsVO implements Serializable {
    private  String ip;
    private  int port = 22;
    private   String username;
    private   String password;

    @Serial
    private static final long serialVersionUID = 1L;
}

package org.qy.panel.entity.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ClientSsh implements Serializable {

    Integer id;
    Integer port;
    String username;
    String password;

    @Serial
    private static final long serialVersionUID = 1L;

}

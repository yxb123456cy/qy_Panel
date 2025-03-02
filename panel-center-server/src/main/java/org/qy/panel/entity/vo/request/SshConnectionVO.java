package org.qy.panel.entity.vo.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

@Data
public class SshConnectionVO implements Serializable {
    int id;
    int port;
    @NotNull
    @Length(min = 1)
    String username;
    @NotNull
    @Length(min = 1)
    String password;


    @Serial
    private static final long serialVersionUID = 1L;
}

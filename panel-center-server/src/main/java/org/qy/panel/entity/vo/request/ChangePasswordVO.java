package org.qy.panel.entity.vo.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ChangePasswordVO implements Serializable {
    @Length(min = 6, max = 20)
    private   String password;
    @Length(min = 6, max = 20)
    private  String new_password;

    @Serial
    private static final long serialVersionUID = 1L;
}

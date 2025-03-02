package org.qy.panel.entity.vo.request;

import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ModifyEmailVO implements Serializable {
    @Email
    String email;
    @Length(max = 6, min = 6)
    String code;

    @Serial
    private static final long serialVersionUID = 1L;
}

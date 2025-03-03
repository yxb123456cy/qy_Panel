package org.qy.panel.entity.vo.request;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class ConfirmResetVO implements Serializable {
    @Email
    private String email;
    @Length(max = 6, min = 6)
    private String code;

    @Serial
    private static final long serialVersionUID = 1L;
}

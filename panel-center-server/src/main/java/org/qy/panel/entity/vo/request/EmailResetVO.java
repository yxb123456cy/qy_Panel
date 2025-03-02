package org.qy.panel.entity.vo.request;

import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

/**
 * 密码重置表单实体
 */
@Data
public class EmailResetVO implements Serializable {
    @Email
    String email;
    @Length(max = 6, min = 6)
    String code;
    @Length(min = 6, max = 20)
    String password;

    @Serial
    private static final long serialVersionUID = 1L;
}

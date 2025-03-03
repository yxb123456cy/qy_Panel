package org.qy.panel.entity.vo.request;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

@Data
public class RenameNodeVO implements Serializable {
    int id;
    @Length(min = 1, max = 10)
    private String node;
    @Pattern(regexp = "(cn|hk|jp|us|sg|kr|de)")
    private  String location;

    @Serial
    private static final long serialVersionUID = 1L;
}

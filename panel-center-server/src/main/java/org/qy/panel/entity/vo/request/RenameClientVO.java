package org.qy.panel.entity.vo.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

@Data
public class RenameClientVO implements Serializable {
    @NotNull
    private   int id;
    @Length(min = 1, max = 10)
    private String name;

    @Serial
    private static final long serialVersionUID = 1L;
}

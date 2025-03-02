package org.qy.panel.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class Client implements Serializable {
    Integer id;
    String name;
    String token;
    String location;
    String node;
    Date registerTime;

    @Serial
    private static final long serialVersionUID = 1L;
}

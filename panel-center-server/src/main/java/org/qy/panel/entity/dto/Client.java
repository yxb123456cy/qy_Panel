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
    private String id;
    private String name;
    private String token;
    private String location;
    private String node;
    private Date registerTime;

    @Serial
    private static final long serialVersionUID = 1L;
}

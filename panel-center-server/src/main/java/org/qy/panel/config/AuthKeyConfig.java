package org.qy.panel.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "qy.panel")
public class AuthKeyConfig {
    private String authKey;
}

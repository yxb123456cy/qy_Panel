package org.qy.panel.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Accessors(chain = true)
@Component
@ConfigurationProperties(prefix = "spring.k8s")
public class KubernetesConnectConfig {
    private String MasterUrl;
    private String token;
    private boolean TrustCerts;
}

package org.qy.panel.config;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import jakarta.annotation.Resource;
import org.qy.panel.entity.KubernetesConnectConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KubeConfig {
    @Resource
    private KubernetesConnectConfig kubernetesConnectConfig;
    @Bean
    public KubernetesClient newKubernetesClient() {
        Config build = new ConfigBuilder().
                withMasterUrl(kubernetesConnectConfig.getMasterUrl())
                .withTrustCerts(kubernetesConnectConfig.isTrustCerts())
                .withOauthToken(kubernetesConnectConfig.getToken())
                .build();
        return new DefaultKubernetesClient(build);
    }
}
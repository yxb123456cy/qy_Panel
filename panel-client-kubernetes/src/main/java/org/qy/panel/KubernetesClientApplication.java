package org.qy.panel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * kubernetes管理服务(使用Master(且为worker)单节点)
 */
@SpringBootApplication
public class KubernetesClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(KubernetesClientApplication.class, args);
    }
}

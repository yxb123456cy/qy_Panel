package org.qy.panel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Docker管理服务
 */
@SpringBootApplication
public class DockerClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(DockerClientApplication.class, args);
    }
}

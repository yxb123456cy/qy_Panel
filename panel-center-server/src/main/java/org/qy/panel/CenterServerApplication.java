package org.qy.panel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 面板中央核心服务;需要引入SaToken;
 */
@SpringBootApplication
public class CenterServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CenterServerApplication.class, args);
    }
}

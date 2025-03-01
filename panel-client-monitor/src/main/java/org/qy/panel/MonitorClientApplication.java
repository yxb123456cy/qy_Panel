package org.qy.panel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 数据采集客户端服务;
 */
//使用MQ传递服务器数据;
@SpringBootApplication
public class MonitorClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(MonitorClientApplication.class, args);
    }
}

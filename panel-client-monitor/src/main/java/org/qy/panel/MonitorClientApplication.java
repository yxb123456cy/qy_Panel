package org.qy.panel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 数据采集客户端服务;
 */
//使用MQ传递服务器数据;
//涉及中间件:consul redis rabbitmq influxDB;

/**
 * 使用中央服务地址+key进行注册;
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
@Slf4j
public class MonitorClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(MonitorClientApplication.class, args);
        log.info("panel-client-monitor running");
    }
}

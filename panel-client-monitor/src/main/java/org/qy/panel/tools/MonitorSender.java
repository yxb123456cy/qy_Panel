package org.qy.panel.tools;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Rabbitmq方案;
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class MonitorSender {


    /**
     * 发送系统基本数据
     */
    public void sendBaseDetail() {
        log.info("向中央服务传递系统基本消息");
    }

    /**
     * 发送系统运行时数据
     */
    public void sendRuntimeDetail() {
        log.info("向中央服务传递系统运行时消息");
    }
}

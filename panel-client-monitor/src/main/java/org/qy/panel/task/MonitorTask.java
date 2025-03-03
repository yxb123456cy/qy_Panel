package org.qy.panel.task;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.qy.panel.tools.MonitorCollect;
import org.qy.panel.tools.MonitorNetUtils;
import org.qy.panel.tools.MonitorSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Http请求方案;
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MonitorTask {
    private final MonitorNetUtils monitorNetUtils;
    private final MonitorCollect collect;
    /**
     * 每五秒向中央服务传递一次运行时数据;
     */
    @Async
    @Scheduled(cron = "*/10 * * * * ? ")
    public void task() {
       // monitorNetUtils.updateRuntimeDetails(collect.monitorRuntimeDetail());
    }
}

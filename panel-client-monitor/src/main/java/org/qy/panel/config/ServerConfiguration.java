package org.qy.panel.config;

import com.alibaba.fastjson2.JSONObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.qy.panel.entity.ConnectionConfig;
import org.qy.panel.tools.MonitorCollect;
import org.qy.panel.tools.MonitorNetUtils;
import org.qy.panel.tools.MonitorSender;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ServerConfiguration implements ApplicationRunner {
    private final MonitorSender sender;
    private final MonitorNetUtils monitorNetUtils;
    private final MonitorCollect monitorCollect;

    @Bean
    ConnectionConfig connectionConfig() {
        log.info("正在加载服务端连接配置...");
        ConnectionConfig config = this.readConfigurationFromFile();
        if (config == null)
            config = this.registerToServer();
        return config;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //更新系统基本信息;
        log.info("正在向服务端更新基本系统信息...");
        /*
          Http请求的方式 而不采用消息队列;
         */
        monitorNetUtils.updateBaseDetails(monitorCollect.collectMonitorBaseDetail());

    }

    private ConnectionConfig registerToServer() {
        Scanner scanner = new Scanner(System.in);
        String authKey, address, ifName;
        do {
            log.info("请输入中央服务生成的用于注册客户端的AuthKey秘钥:");
            authKey = scanner.nextLine();
            List<String> ifs = monitorCollect.listNetworkInterfaceName();
            if (ifs.size() > 1) {
                log.info("检测到您的主机有多个网卡设备: {}", ifs);
                do {
                    log.info("请选择需要监控的设备名称:");
                    ifName = scanner.nextLine();
                } while (!ifs.contains(ifName));
            } else {
                ifName = ifs.get(0);
            }
        } while (monitorNetUtils.registerToCenterServer(authKey));
        ConnectionConfig config = new ConnectionConfig("http://localhost:8080", authKey, ifName);
        this.saveConfigurationToFile(config);
        return config;
    }

    private void saveConfigurationToFile(ConnectionConfig config) {
        File dir = new File("config");
        if (!dir.exists() && dir.mkdir())
            log.info("创建用于保存服务端连接信息的目录已完成");
        File file = new File("config/server.json");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(JSONObject.from(config).toJSONString());
        } catch (IOException e) {
            log.error("保存配置文件时出现问题", e);
        }
        log.info("服务端连接信息已保存成功！");
    }

    private ConnectionConfig readConfigurationFromFile() {
        File configurationFile = new File("config/server.json");
        if (configurationFile.exists()) {
            try (FileInputStream stream = new FileInputStream(configurationFile)) {
                String raw = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
                return JSONObject.parseObject(raw).to(ConnectionConfig.class);
            } catch (IOException e) {
                log.error("读取配置文件时出错", e);
            }
        }
        return null;
    }
}

package org.qy.panel.tools;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.qy.panel.entity.BaseDetail;
import org.qy.panel.entity.Response;
import org.qy.panel.entity.RuntimeDetail;
import org.springframework.stereotype.Component;



@Component
@Slf4j
public class MonitorNetUtils {


    @Resource
    private MyForestClient forestClient;


    public boolean registerToCenterServer(String authKey) {
        log.info("正在像中央服务注册，请稍后...");
        Response<Boolean> response = forestClient.register(authKey);
        if (response.isSuccess()) {
            log.info("客户端注册已完成！");
        } else {
            log.error("客户端注册失败: {}", response.getMessage());
        }
        return response.isSuccess();
    }

    public void updateBaseDetails(BaseDetail detail) {
        Response<Boolean> response = forestClient.updateBaseDetails(detail);
        if (response.isSuccess()) {
            log.info("系统基本信息已更新完成");
        } else {
            log.error("系统基本信息更新失败: {}", response.getMessage());
        }
    }

    public void updateRuntimeDetails(RuntimeDetail detail) {
        Response<Boolean> response = forestClient.updateRuntimeDetails(detail);
        if (!response.isSuccess()) {
            log.warn("更新运行时状态时，接收到服务端的异常响应内容: {}", response.getMessage());
        }
    }

    /**
     *
     * @param url  请求APi路径;
     * @param address  服务地址
     * @param authKey 认证key;
     * @return Response<Boolean>
     */
    //构建请求;
    private Response<Boolean> doGet(String url, String address, String authKey) {
        try {
            log.info("");
        } catch (Exception e) {
            log.error("在发起服务端请求时出现问题", e);
            return Response.fail(e.getMessage());
        }
        return Response.success();
    }

    //构建请求
    private Response<Boolean> doPost(String url, String address, Object data) {
        try {
            log.info("");
        } catch (Exception e) {
            log.error("在发起服务端请求时出现问题", e);
            return Response.fail(e.getMessage());
        }
        return Response.success();
    }
}

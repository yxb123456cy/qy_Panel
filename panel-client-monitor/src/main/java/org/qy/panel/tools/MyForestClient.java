package org.qy.panel.tools;

import com.dtflys.forest.annotation.*;
import org.qy.panel.entity.BaseDetail;
import org.qy.panel.entity.Response;
import org.qy.panel.entity.RuntimeDetail;

@BaseRequest(baseURL = "http://localhost:8080")     // 接口域名
public interface MyForestClient {
    // 方法的URL不必再写域名部分
    @Request(
            headers = {
                    "Content-Type: application/json"
            }
    )
    @Get("/client/register")
    Response<Boolean> register(@Query("authKey") String authKey);

    /**
     * 被@JSONBody注解修饰的参数会根据其类型被自定解析为JSON字符串
     * 使用@JSONBody注解时可以省略 contentType = "application/json"属性设置
     */
    @Post("/client/detail")
    Response<Boolean> updateBaseDetails(@JSONBody BaseDetail baseDetail);

    @Post("/client/runtime")
    Response<Boolean> updateRuntimeDetails(@JSONBody RuntimeDetail runtimeDetail);
}

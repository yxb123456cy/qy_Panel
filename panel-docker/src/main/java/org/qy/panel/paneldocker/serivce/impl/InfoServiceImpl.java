package org.qy.panel.paneldocker.serivce.impl;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.api.model.Version;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.qy.panel.paneldocker.entity.Response;
import org.qy.panel.paneldocker.serivce.InfoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class InfoServiceImpl implements InfoService {
    private final DockerClient dockerClient;


    @Override
    public Response<Map<String, Object>> getInfo() {
        final Info info = dockerClient.infoCmd().exec();
        final Version version = dockerClient.versionCmd().exec();
        Map<String, Object> map = new HashMap<>();
        map.put("info", info);
        map.put("version", version);
        return Response.success(map);
    }
}

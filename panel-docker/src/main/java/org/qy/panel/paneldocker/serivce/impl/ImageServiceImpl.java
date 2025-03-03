package org.qy.panel.paneldocker.serivce.impl;

import com.github.dockerjava.api.DockerClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.qy.panel.paneldocker.serivce.ImageService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final DockerClient dockerClient;

    private void test() {
        dockerClient.searchImagesCmd("")
                .exec();//搜索镜像;
        dockerClient.inspectImageCmd("imageID").exec();//获取镜像详情;
        dockerClient.listImagesCmd();//镜像list;
        //docker pull;
        dockerClient.pullImageCmd("nginx:latest");
        dockerClient.pushImageCmd("nginx:latest");//推送Docker镜像至仓库
        dockerClient.removeImageCmd("imageID").exec();
        dockerClient.tagImageCmd("imageId", "仓库地址", "新的Tag")
                .exec();
    }
}

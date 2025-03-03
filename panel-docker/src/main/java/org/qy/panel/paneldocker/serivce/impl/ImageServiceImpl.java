package org.qy.panel.paneldocker.serivce.impl;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.InspectImageResponse;
import com.github.dockerjava.api.exception.NotFoundException;
import com.github.dockerjava.api.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.qy.panel.paneldocker.serivce.ImageService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

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
        dockerClient.pushImageCmd("nginx:latest");//推送Docker镜像至仓库
        dockerClient.removeImageCmd("imageID").exec();
        dockerClient.tagImageCmd("imageId", "仓库地址", "新的Tag")
                .exec();
    }

    @Override
    public List<Image> list(String key) {
        return dockerClient.listImagesCmd().exec();
    }

    @Override
    public InspectImageResponse inspect(String imageId) {
        return dockerClient.inspectImageCmd(imageId).exec();
    }

    @Override
    public void tag(String imageId, String newTag) {
        final InspectImageResponse image = inspect(imageId);
        if (image == null) {
            throw new RuntimeException("操作失败，镜像不存在");
        }
        dockerClient.tagImageCmd(imageId, Objects.requireNonNull(image.getRepoTags()).get(0), newTag).exec();
    }

    @Override
    public void remove(String imageId, Boolean force) {
        dockerClient.removeImageCmd(imageId).withForce(force).exec();
    }

    @Override
    public void export(String imageId) {

    }

    @Override
    public List<SearchItem> search(String key) {
        return dockerClient.searchImagesCmd(key)
                .exec();
    }

    @Override
    public void remove() {

    }

    @Override
    public void importByFile(String file) {

    }

    @Override
    public void importByTar(String file) {

    }

    @Override
    public boolean exist(String imageId) {
        return false;
    }

    @Override
    public PruneResponse pruneImage() {
        return dockerClient.pruneCmd(PruneType.IMAGES).exec();
    }

    @Override
    public InputStream save(String nameTag) {
        return null;
    }

    @Override
    public void saveBatch(List<String> nameTagList, HttpServletRequest request, HttpServletResponse response) {

    }
}

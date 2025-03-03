package org.qy.panel.paneldocker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.api.model.Version;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class PanelDockerApplication implements ApplicationRunner {
    private final DockerClient dockerClient;

    @Autowired
    public PanelDockerApplication(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(PanelDockerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        dockerClient.pingCmd().exec();
        Info info = dockerClient.infoCmd().exec();
        Version version = dockerClient.versionCmd().exec();
        log.info("docker info:{}", info);
        log.info("docker version:{}", version);

    }

}

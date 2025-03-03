package org.qy.panel;

import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * kubernetes管理服务(使用Master(且为worker)单节点)
 */
@Slf4j
@SpringBootApplication
public class KubernetesClientApplication implements ApplicationRunner {

    private final KubernetesClient kubernetesClient;

    @Autowired
    public KubernetesClientApplication(KubernetesClient client) {
        this.kubernetesClient = client;
    }

    public static void main(String[] args) {
        SpringApplication.run(KubernetesClientApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        VersionInfo kubernetesVersion = kubernetesClient.getKubernetesVersion();
        log.error("kubernetes go version:{}",kubernetesVersion.getGoVersion());
        log.error("git version:{}",kubernetesVersion.getGitVersion());
        log.error("build Date:{}",kubernetesVersion.getBuildDate());
        log.error("Platform:{}",kubernetesVersion.getPlatform());
        log.error("Major:{}",kubernetesVersion.getMajor());
        log.error("Minor:{}",kubernetesVersion.getMinor());
        log.error("GitCommit:{}",kubernetesVersion.getGitCommit());
        log.error("Compiler:{}",kubernetesVersion.getCompiler());
    }
}

package org.qy.panel.controller;

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.qy.panel.service.NameSpaceService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@CrossOrigin("*")
@Tag(name = "namespace 控制器")
@RestController
@RequestMapping("kube/api/namespace")
@RequiredArgsConstructor
@Slf4j
public class NameSpaceController {
    private final NameSpaceService service;
    private final KubernetesClient kubernetesClient;

    @GetMapping("/list")
    @Operation(summary = "获取所有命名空间 NameSpace")
    public List<Namespace> list() {
        NamespaceList namespaceList = kubernetesClient.namespaces().list();
        List<Namespace> namespaces = namespaceList.getItems();
        log.info("namespaces:{}",namespaces);
        return namespaces;
    }
}

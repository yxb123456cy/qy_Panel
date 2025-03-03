package org.qy.panel.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.qy.panel.service.DeploymentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Validated
@CrossOrigin("*")
@Tag(name = "deployment 控制器")
@RequestMapping("kube/api/deployment")
@RequiredArgsConstructor
@Slf4j

public class DeploymentController {
    private final DeploymentService service;
}

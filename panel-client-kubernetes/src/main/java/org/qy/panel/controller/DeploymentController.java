package org.qy.panel.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.qy.panel.service.DeploymentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deployment")
@RequiredArgsConstructor
@Slf4j
public class DeploymentController {
    private final DeploymentService service;
}

package org.qy.panel.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.qy.panel.service.ServiceDao;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@CrossOrigin("*")
@Tag(name = "service 控制器")
@RestController
@RequestMapping("kube/api/service")
@RequiredArgsConstructor
@Slf4j
public class ServiceController {
    private final ServiceDao dao;
}

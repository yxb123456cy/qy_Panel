package org.qy.panel.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.qy.panel.service.NameSpaceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kube/api/namespace")
@RequiredArgsConstructor
@Slf4j
public class NameSpaceController {
    private final NameSpaceService service;
}

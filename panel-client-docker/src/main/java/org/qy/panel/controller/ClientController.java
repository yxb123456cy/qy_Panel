package org.qy.panel.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "Docker客户端")
@RestController
@RequestMapping("/api/endpoint")
@RequiredArgsConstructor
@Slf4j
public class ClientController {
}

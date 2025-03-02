package org.qy.panel.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Tag(name = "Docker网络管理")
@RestController
@RequestMapping("/api/network")
@RequiredArgsConstructor
@Slf4j
public class NetWorkController {


}

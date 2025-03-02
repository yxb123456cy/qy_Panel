package org.qy.panel.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/api/container")
@Tag(name = "Docker容器管理")
@RequiredArgsConstructor

public class ContainerController extends BaseController {


}

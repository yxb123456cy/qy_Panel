package org.qy.panel.paneldocker.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.qy.panel.paneldocker.serivce.ImageService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@Tag(name = "Docker镜像管理")
@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
@Slf4j
@Validated
public class ImageController {
    private final ImageService service;


}

package org.qy.panel.paneldocker.controller;

import com.github.dockerjava.api.command.CreateVolumeResponse;
import com.github.dockerjava.api.command.InspectVolumeResponse;
import com.github.dockerjava.api.command.ListVolumesResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.qy.panel.paneldocker.entity.Response;
import org.qy.panel.paneldocker.entity.dto.CreateVolumeDTO;
import org.qy.panel.paneldocker.serivce.VolumeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@CrossOrigin("*")
@Tag(name = "Docker券管理")
@RestController
@RequestMapping("/api/volume")
@RequiredArgsConstructor
@Slf4j
@Validated
public class VolumeController {
    private final VolumeService service;

    /**
     * 卷列表
     */
    @GetMapping("/list")
    @Operation(summary = "获取券列表")
    Response<ListVolumesResponse> list() {
        return service.list();
    }

    /**
     * 创建新的存储卷
     */
    @GetMapping("/create")
    @Operation(summary = "创建新的存储卷")
    Response<CreateVolumeResponse> create(@RequestBody CreateVolumeDTO volumeDTO) {
        return service.create(volumeDTO.getName(), volumeDTO.getDriver());
    }

    /**
     * 卷详情
     *
     * @param name 卷名
     */
    @GetMapping("/inspect")
    @Operation(summary = "获取卷详情")
    Response<InspectVolumeResponse> inspect(@RequestParam("name")@NonNull @NotBlank String name) {
        return service.inspect(name);
    }

    /**
     * 移除卷
     *
     * @param name 卷名称
     */
    @GetMapping("/remove")
    @Operation(summary = "移除卷")
    Response<Void> remove(@RequestParam("name") @NonNull @NotBlank String name) {
        return null;
    }
}



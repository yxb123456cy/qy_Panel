package org.qy.panel.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.qy.panel.entity.Response;
import org.qy.panel.entity.vo.request.ClientDetailVO;
import org.qy.panel.service.ClientService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@Slf4j
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;

    @GetMapping("/register")
    public Response<Boolean> register(@RequestParam("authKey") String authToken) {
        return service.register(authToken);
    }


    @PostMapping("/detail")
    public Response<Boolean> updateBaseDetails(@RequestHeader("authToken") String authToken, @RequestBody @Valid ClientDetailVO clientDetailVO) {
        return service.saveClientDetail(authToken, clientDetailVO);
    }
}

package org.qy.panel.controller;


import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.qy.panel.entity.Response;
import org.qy.panel.entity.dto.Account;
import org.qy.panel.entity.vo.request.RenameClientVO;
import org.qy.panel.entity.vo.request.RenameNodeVO;
import org.qy.panel.entity.vo.request.RuntimeDetailVO;
import org.qy.panel.entity.vo.request.SshConnectionVO;
import org.qy.panel.entity.vo.response.*;
import org.qy.panel.service.AccountService;
import org.qy.panel.service.ClientService;
import org.qy.panel.service.MonitorService;
import org.qy.panel.tools.Const;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@Slf4j
@RequestMapping("/monitor")
@RequiredArgsConstructor
public class MonitorController {
    private final MonitorService service;

    private final ClientService clientService;


    private final AccountService accountService;

    /**
     * 获取所有client
     * @param userId  userId
     * @param userRole userRole
     * @return Response<List<ClientPreviewVO>>
     */
    @GetMapping("/list")
    public Response<List<ClientPreviewVO>> listAllClient(@RequestAttribute(Const.ATTR_USER_ID) int userId,
                                                         @RequestAttribute(Const.ATTR_USER_ROLE) String userRole) {
        return null;

    }

    @GetMapping("/simple-list")
    public Response<List<ClientSimpleVO>> simpleClientList(@RequestAttribute(Const.ATTR_USER_ROLE) String userRole) {
        return null;
    }

    /**
     * 重命名主机
     * @param vo RenameClientVO
     * @param userId  userId
     * @param userRole userRole
     * @return Response<Void>
     */


    @PostMapping("/rename")
    public Response<Void> renameClient(@RequestBody @Valid RenameClientVO vo,
                                       @RequestAttribute(Const.ATTR_USER_ID) int userId,
                                       @RequestAttribute(Const.ATTR_USER_ROLE) String userRole) {
        return null;
    }

    //重命名主机节点;
    @PostMapping("/node")
    public Response<Void> renameNode(@RequestBody @Valid RenameNodeVO vo,
                                     @RequestAttribute(Const.ATTR_USER_ID) int userId,
                                     @RequestAttribute(Const.ATTR_USER_ROLE) String userRole) {
        return null;
    }

    //获取主机 details;
    @GetMapping("/details")
    public Response<ClientDetailsVO> details(int clientId,
                                             @RequestAttribute(Const.ATTR_USER_ID) int userId,
                                             @RequestAttribute(Const.ATTR_USER_ROLE) String userRole) {
        return null;
    }

    //获取历史运行时数据;
    @GetMapping("/runtime-history")
    public Response<RuntimeHistoryVO> runtimeDetailsHistory(int clientId,
                                                            @RequestAttribute(Const.ATTR_USER_ID) int userId,
                                                            @RequestAttribute(Const.ATTR_USER_ROLE) String userRole) {
        return null;
    }

    //获取运行时数据
    @GetMapping("/runtime-now")
    public Response<RuntimeDetailVO> runtimeDetailsNow(int clientId,
                                                       @RequestAttribute(Const.ATTR_USER_ID) int userId,
                                                       @RequestAttribute(Const.ATTR_USER_ROLE) String userRole) {
        return null;
    }


    @GetMapping("/register")
    public Response<String> registerToken(@RequestAttribute(Const.ATTR_USER_ROLE) String userRole) {
        return null;
    }

    //删除某个已注册主机
    @GetMapping("/delete")
    public Response<String> deleteClient(int clientId,
                                         @RequestAttribute(Const.ATTR_USER_ROLE) String userRole) {
        return null;
    }

    //保存SSH连接信息
    @PostMapping("/ssh-save")
    public Response<Void> saveSshConnection(@RequestBody @Valid SshConnectionVO vo,
                                            @RequestAttribute(Const.ATTR_USER_ID) int userId,
                                            @RequestAttribute(Const.ATTR_USER_ROLE) String userRole) {
        return null;
    }

    //修改SSH连接信息;
    @GetMapping("/ssh")
    public Response<SshSettingsVO> sshSettings(int clientId,
                                               @RequestAttribute(Const.ATTR_USER_ID) int userId,
                                               @RequestAttribute(Const.ATTR_USER_ROLE) String userRole) {
        return null;
    }


    private List<Integer> accountAccessClients(int uid) {
        Account account = new Account();
        return List.of(1,2,3);
    }

    private boolean isAdminAccount(String role) {
        role = role.substring(5);
        return Const.ROLE_ADMIN.equals(role);
    }

    private boolean permissionCheck(int uid, String role, int clientId) {
        if (this.isAdminAccount(role)) return true;
        return this.accountAccessClients(uid).contains(clientId);
    }
}

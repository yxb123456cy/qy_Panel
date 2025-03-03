package org.qy.panel.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.qy.panel.entity.Response;
import org.qy.panel.entity.vo.request.ChangePasswordVO;
import org.qy.panel.entity.vo.request.CreateSubAccountVO;
import org.qy.panel.entity.vo.request.ModifyEmailVO;
import org.qy.panel.entity.vo.response.SubAccountVO;
import org.qy.panel.service.AccountService;
import org.qy.panel.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@Slf4j
@Validated
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    // 一个管理员(权限为admin) 多个子用户(权限为common)


    /**
     * 修改密码 权限为admin与common
     * @param vo vo
     * @return Response<Void>
     */
    @PostMapping("/change-password")
    public Response<Void> changePassword(@RequestBody @Valid ChangePasswordVO vo) {
        return service.changePassword(vo);
    }

    /**
     * 修改邮箱 权限为admin与common
     * @param vo ModifyEmailVO
     * @return Response<Void>
     */

    @PostMapping("/modify-email")
    public Response<Void> modifyEmail(@RequestBody @Valid ModifyEmailVO vo) {
        return service.modifyEmail(vo);
    }

    /**
     * 创建面板子用户 需要权限为admin
     * @param vo CreateSubAccountVO
     * @return Response<Void>
     */
    @PostMapping("/sub/create")
    public Response<Void> createSubAccount(@RequestBody @Valid CreateSubAccountVO vo) {
        return service.createSubAccount(vo);
    }

    /**
     * 删除子用户 需要权限为admin
     * @param uid 面板子用户ID
     * @return Response<Void>
     */
    @GetMapping("/sub/delete")
    public Response<Void> deleteSubAccount(@RequestParam long uid) {
        return service.deleteSubAccount(uid);
    }

    /**
     * 获取面板子用户列表 需要权限为admin
     * @return Response<List < SubAccountVO>>
     */
    @GetMapping("/sub/list")
    public Response<List<SubAccountVO>> subAccountList() {
        return service.subAccountList();
    }
}

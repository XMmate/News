package com.heima.user.controller;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.UserListDto;
import com.heima.user.service.ApUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class ApUserController {
    @Autowired
    private ApUserService apUserService;
    /**
     * 查询列表
     */

    @PostMapping("/list")
    private ResponseResult listAuth(@RequestBody UserListDto userListDto){
        System.out.println("路由可达");
       return apUserService.listAuth( userListDto);
    }
    /*
    * 审核失败
    * */

    @PostMapping("/authFail")
    public ResponseResult authFail(@RequestBody UserListDto dto){
     return apUserService.authFail(dto);
    }

    @PostMapping("/authPass")
    public ResponseResult authPass(@RequestBody UserListDto dto ){
        return apUserService.authPass(dto);
    }
}

package com.heima.admin.controller.v1;

import com.heima.admin.service.AdminService;
import com.heima.model.admin.AdUser;
import com.heima.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AdminLoginContoller {
    @Autowired
    private AdminService adminService;

    @PostMapping("/in")
    public ResponseResult login(@RequestBody AdUser dto){
      return   adminService.login(dto);

    }
}


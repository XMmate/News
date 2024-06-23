package com.heima.user.controller;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.UserRelationDto;
import com.heima.user.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class FollowController {
        @Autowired
         private FollowService followService;

   /*关注与取消关注*/
    @PostMapping("/user_follow")
    private ResponseResult user_follow(@RequestBody UserRelationDto userRelationDto){
        return followService.user_follow(userRelationDto);
    }
}

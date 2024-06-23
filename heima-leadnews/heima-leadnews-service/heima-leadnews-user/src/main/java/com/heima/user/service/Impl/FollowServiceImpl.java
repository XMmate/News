package com.heima.user.service.Impl;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.user.dtos.UserRelationDto;
import com.heima.user.service.FollowService;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements FollowService {
    @Override
    public ResponseResult user_follow(UserRelationDto userRelationDto) {
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }
}

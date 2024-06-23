package com.heima.user.service;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.UserRelationDto;

public interface FollowService {
    ResponseResult user_follow(UserRelationDto userRelationDto);
}

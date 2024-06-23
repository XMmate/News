package com.heima.behavior.service;

import com.heima.model.behavior.dtos.LikesBehaviorDto;
import com.heima.model.behavior.dtos.ReadBehavior;
import com.heima.model.behavior.dtos.UnLikesBehaviorDto;
import com.heima.model.common.dtos.ResponseResult;
import org.springframework.web.bind.annotation.RestController;

public interface LikesService  {
    ResponseResult likes_behavior(LikesBehaviorDto likesBehaviorDto);

    ResponseResult un_likes_behavior(UnLikesBehaviorDto unLikesBehaviorDto);

    ResponseResult read_behavior(ReadBehavior readBehavior);
}

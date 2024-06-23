package com.heima.behavior.controller.v1;

import com.heima.behavior.service.LikesService;
import com.heima.model.behavior.dtos.LikesBehaviorDto;
import com.heima.model.behavior.dtos.ReadBehavior;
import com.heima.model.behavior.dtos.UnLikesBehaviorDto;
import com.heima.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RestController
public class LikesController {
    @Autowired
    private LikesService likesService;

    /*喜欢*/
    @PostMapping("/likes_behavior")
     private ResponseResult likes_behavior(@RequestBody LikesBehaviorDto likesBehaviorDto){
        System.out.println("路由成功");
     return    likesService.likes_behavior(likesBehaviorDto);

 }
/*阅读*/
 @PostMapping("/read_behavior")
    private ResponseResult read_behavior(@RequestBody ReadBehavior readBehavior){

     return likesService.read_behavior( readBehavior);

 }

 /*不喜欢*/

    @PostMapping("/un_likes_behavior")
    private ResponseResult un_likes_behavior(@RequestBody UnLikesBehaviorDto unLikesBehaviorDto){
        return  likesService.un_likes_behavior(unLikesBehaviorDto);
    }


}

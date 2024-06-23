package com.heima.behavior.service.Impl;

import com.alibaba.fastjson.JSON;
import com.heima.behavior.service.LikesService;
import com.heima.common.constants.BehaviorConstants;
import com.heima.common.constants.HotArticleConstants;
import com.heima.common.redis.CacheService;
import com.heima.model.behavior.dtos.LikesBehaviorDto;
import com.heima.model.behavior.dtos.ReadBehavior;
import com.heima.model.behavior.dtos.UnLikesBehaviorDto;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.mess.UpdateArticleMess;
import com.heima.model.user.pojos.ApUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import com.heima.utils.thread.AppThreadLocalUtil;
import static com.alibaba.nacos.client.config.utils.ParamUtils.checkParam;

@Service
@Slf4j
public class LikesServiceImpl implements LikesService {

    @Autowired
    private CacheService cacheService;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    /*点赞*/
    @Override
    public ResponseResult likes_behavior(LikesBehaviorDto likesBehaviorDto) {
        //1.检查参数
        if (likesBehaviorDto == null || likesBehaviorDto.getArticleId() == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }

        //2.是否登录
        ApUser user = AppThreadLocalUtil.getUser();
        if (user == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }

        UpdateArticleMess mess = new UpdateArticleMess();
        mess.setArticleId(likesBehaviorDto.getArticleId());
        mess.setType(UpdateArticleMess.UpdateArticleType.LIKES);

        //3.点赞  保存数据
        if (likesBehaviorDto.getOperation() == 0) {
            Object obj = cacheService.hGet(BehaviorConstants.LIKE_BEHAVIOR + likesBehaviorDto.getArticleId().toString(), user.getId().toString());
            if (obj != null) {
                return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "已点赞");
            }
            // 保存当前key
            log.info("保存当前key:{} ,{}, {}", likesBehaviorDto.getArticleId(), user.getId(), likesBehaviorDto);
            cacheService.hPut(BehaviorConstants.LIKE_BEHAVIOR + likesBehaviorDto.getArticleId().toString(), user.getId().toString(), JSON.toJSONString(likesBehaviorDto));
            mess.setAdd(1);
        } else {
            // 删除当前key
            log.info("删除当前key:{}, {}", likesBehaviorDto.getArticleId(), user.getId());
            cacheService.hDelete(BehaviorConstants.LIKE_BEHAVIOR +likesBehaviorDto.getArticleId().toString(), user.getId().toString());
            mess.setAdd(-1);
        }

        //发送消息，数据聚合
        kafkaTemplate.send(HotArticleConstants.HOT_ARTICLE_SCORE_TOPIC, JSON.toJSONString(mess));


        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);


    }

    @Override
    public ResponseResult un_likes_behavior(UnLikesBehaviorDto unLikesBehaviorDto) {
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public ResponseResult read_behavior(ReadBehavior readBehavior) {
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }
}

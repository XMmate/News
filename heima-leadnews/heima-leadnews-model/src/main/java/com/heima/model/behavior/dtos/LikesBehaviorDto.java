package com.heima.model.behavior.dtos;

import lombok.Data;

@Data
public class LikesBehaviorDto {
    /*文章id*/
    public Long articleId;
    /*0 点赞   1 取消点赞*/
    public Integer operation;

    /*0文章  1动态   2评论*/
    public Integer type;
}

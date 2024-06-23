package com.heima.wemedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.NewsAuthDto;
import com.heima.model.wemedia.dtos.WmNewsDto;
import com.heima.model.wemedia.pojos.WmNews;
import com.heima.model.wemedia.pojos.WmNewsPageReqDto;

import java.lang.reflect.InvocationTargetException;

public interface WmNewsService extends IService<WmNews> {
    public ResponseResult findAll(WmNewsPageReqDto dto);

    public ResponseResult  submitNews(WmNewsDto dto) throws InvocationTargetException, IllegalAccessException;

    /**
     * 文章的上下架
     * @param dto
     * @return
     */
    public ResponseResult downOrUp(WmNewsDto dto);

    ResponseResult list_vo(NewsAuthDto newsAuthDto);

    ResponseResult selectOne(Integer id);

    ResponseResult auth_fail(NewsAuthDto newsAuthDto);

    ResponseResult auth_pass(NewsAuthDto newsAuthDto);
}

package com.heima.wemedia.service;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.WmChannelDto;
import com.heima.model.wemedia.pojos.WmChannel;
import com.heima.model.wemedia.pojos.WmNewsPageReqDto;

public interface WmChannelService {
    public ResponseResult findAll();

    ResponseResult listChannel(WmChannelDto dto);

    ResponseResult deleteChannel(Integer id);

    ResponseResult saveChannel(WmChannel wmChannel);

    ResponseResult updateChannel(WmChannel wmChannel);
}

package com.heima.wemedia.service;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.sensitive.dtos.AdSensitive;

public interface WmSensitiveService {
    ResponseResult listSensitive();

    ResponseResult delectChannel(Integer id);

    ResponseResult saveSensitive(AdSensitive adSensitive);

    ResponseResult updateSensitive(AdSensitive adSensitive);
}

package com.heima.admin.service;

import com.heima.model.admin.AdUser;
import com.heima.model.common.dtos.ResponseResult;

public interface AdminService {
    public ResponseResult login(AdUser dto);
}

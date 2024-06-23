package com.heima.admin.service.Impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.admin.mapper.AdminMapper;
import com.heima.admin.service.AdminService;
import com.heima.model.admin.AdUser;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.utils.common.AppJwtUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


import java.util.HashMap;
import java.util.Map;
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper,AdUser> implements AdminService {
    @Override
    public ResponseResult login(AdUser dto) {
        if (dto.getName()==null ||dto.getPassword()==null){
            return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
        }
        AdUser adUser = getOne(Wrappers.<AdUser>lambdaQuery().eq(AdUser::getName, dto.getName()));
        String salt = dto.getSalt();
        String pswd = dto.getPassword();
        pswd = DigestUtils.md5DigestAsHex((pswd + salt).getBytes());
        if (!pswd.equals(adUser.getPassword())) {
            //密码错误
            return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
        }
        //1.3 返回数据  jwt
        Map<String, Object> map = new HashMap<>();
        map.put("token", AppJwtUtil.getToken(adUser.getId().longValue()));
        adUser.setSalt("");
        adUser.setPassword("");
        map.put("user", adUser);
        System.out.println(map);
        return ResponseResult.okResult(map);
    }


}

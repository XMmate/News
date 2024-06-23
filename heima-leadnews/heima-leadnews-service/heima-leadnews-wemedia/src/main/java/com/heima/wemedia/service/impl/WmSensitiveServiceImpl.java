package com.heima.wemedia.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.sensitive.dtos.AdSensitive;
import com.heima.model.sensitive.pojo.Sensitives;
import com.heima.model.wemedia.pojos.WmSensitive;
import com.heima.wemedia.mapper.WmSensitiveMapper;
import com.heima.wemedia.service.WmSensitiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WmSensitiveServiceImpl implements WmSensitiveService {
    @Autowired
    private WmSensitiveMapper wmSensitiveMapper;
    @Override
    public ResponseResult listSensitive() {
        QueryWrapper queryWrapper=new QueryWrapper();
        List list = wmSensitiveMapper.selectList(queryWrapper);
        return ResponseResult.okResult(list);
    }

    @Override
    public ResponseResult delectChannel(Integer id) {
        wmSensitiveMapper.deleteById(id);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public ResponseResult saveSensitive(AdSensitive adSensitive) {
        if (adSensitive.getSensitives()==null)return ResponseResult.errorResult(AppHttpCodeEnum. PARAM_REQUIRE);
        if (adSensitive.getCreatedTime()==null)adSensitive.setCreatedTime(new Date());

        WmSensitive wmSensitive=new WmSensitive();
                wmSensitive.setSensitives(adSensitive.getSensitives());
                wmSensitive.setCreatedTime(adSensitive.getCreatedTime());
                wmSensitive.setId(adSensitive.getId());
        wmSensitiveMapper.insert(wmSensitive);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public ResponseResult updateSensitive(AdSensitive adSensitive) {
        QueryWrapper<WmSensitive> sensitivesQueryWrapper = new QueryWrapper<>();
        sensitivesQueryWrapper.eq("id",adSensitive.getId());
        WmSensitive wmSensitive=new WmSensitive();
        wmSensitive.setSensitives(adSensitive.getSensitives());
        wmSensitive.setCreatedTime(adSensitive.getCreatedTime());
        wmSensitive.setId(adSensitive.getId());
        wmSensitiveMapper.update(wmSensitive,sensitivesQueryWrapper);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }
}

package com.heima.wemedia.controller.v1;

import com.baomidou.mybatisplus.extension.api.R;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.WmChannelDto;
import com.heima.model.wemedia.pojos.WmChannel;
import com.heima.model.wemedia.pojos.WmNewsPageReqDto;
import com.heima.wemedia.service.WmChannelService;
import com.heima.wemedia.service.WmNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/channel")
public class WmchannelController {
    @Autowired
    private WmChannelService wmChannelService;

    @GetMapping("/channels")
    public ResponseResult findAll(){
        return wmChannelService.findAll();
    }

    @PostMapping("/list")
    public ResponseResult listChannel(@RequestBody WmChannelDto dto){
       return wmChannelService.listChannel(dto);
    }
    @GetMapping("/del/{id}")
    public ResponseResult deleteChannel(@PathVariable Integer id){

      return   wmChannelService.deleteChannel(id);
    }

    @PostMapping("/save")
    public ResponseResult saveChannel(@RequestBody WmChannel wmChannel){
     return    wmChannelService.saveChannel(wmChannel);
    }

    @PostMapping("/update")
    public ResponseResult updateChannel(@RequestBody WmChannel wmChannel ){
        return wmChannelService.updateChannel(wmChannel);
    }

}

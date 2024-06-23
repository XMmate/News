package com.heima.wemedia.controller.v1;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.sensitive.dtos.AdSensitive;
import com.heima.wemedia.service.WmSensitiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sensitive")
public class WmSensitiveController {
    @Autowired
    private WmSensitiveService wmSensitiveService;

    @PostMapping("/list")
    public ResponseResult listSensitive(){
     return    wmSensitiveService.listSensitive();
    }


    @DeleteMapping("/del/{id}")
    public ResponseResult delectChannel(@PathVariable Integer id){
        return   wmSensitiveService.delectChannel( id);
    }

    @PostMapping("/save")
    private ResponseResult  saveSensitive(@RequestBody AdSensitive adSensitive){
        return wmSensitiveService.saveSensitive(adSensitive);
    }

    @PostMapping("/update")
    private ResponseResult updateSensitive(@RequestBody AdSensitive adSensitive){
        return  wmSensitiveService.updateSensitive(adSensitive);
    }
}

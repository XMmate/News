package com.heima.wemedia.controller.v1;

import com.heima.model.common.dtos.PageResponseResult;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.NewsAuthDto;
import com.heima.model.wemedia.dtos.WmNewsDto;
import com.heima.model.wemedia.pojos.WmNewsPageReqDto;
import com.heima.wemedia.service.WmNewsService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/api/v1/news")
public class WmNewsController {
    @Autowired
    private WmNewsService wmNewsService;
    @PostMapping("/list")
    public ResponseResult findAll(@RequestBody WmNewsPageReqDto dto){
        return  wmNewsService.findAll(dto);
    }

    @PostMapping("/submit")
    public ResponseResult submitNews(@RequestBody WmNewsDto dto) throws InvocationTargetException, IllegalAccessException {
        return  wmNewsService.submitNews(dto);
    }

    @PostMapping("/down_or_up")
    public ResponseResult downOrUp(@RequestBody WmNewsDto dto){
        return wmNewsService.downOrUp(dto);
    }


  @PostMapping("/list_vo")
  public ResponseResult list_vo(@RequestBody NewsAuthDto newsAuthDto){
     return wmNewsService.list_vo(newsAuthDto);

  }

  @GetMapping("/one_vo/{id}")
    private ResponseResult selectOne(@PathVariable Integer id ){
     return wmNewsService.selectOne(id);
  }

  @PostMapping("/auth_fail")
    private ResponseResult auth_fail(@RequestBody NewsAuthDto newsAuthDto){
     return wmNewsService.auth_fail(newsAuthDto);
  }

  @PostMapping("/auth_pass")
    private  ResponseResult auth_pass(@RequestBody NewsAuthDto newsAuthDto ){
        return wmNewsService.auth_pass(newsAuthDto);
  }

}

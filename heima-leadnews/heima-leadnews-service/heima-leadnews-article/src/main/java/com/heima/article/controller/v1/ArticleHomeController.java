package com.heima.article.controller.v1;

import com.heima.apis.article.IArticleClient;
import com.heima.article.service.ApArticleService;
import com.heima.article.service.Impl.ArticleServiceImpl;
import com.heima.common.constants.ArticleConstants;
import com.heima.model.article.dtos.ArticleDto;
import com.heima.model.article.dtos.ArticleHomeDto;
import com.heima.model.article.dtos.ArticleInfoDto;
import com.heima.model.common.dtos.ResponseResult;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/article")
@RestController

public class ArticleHomeController {
    @Autowired
    private ApArticleService apArticleService;


    //首页
    @PostMapping("/load")
    private ResponseResult load(@RequestBody ArticleHomeDto articleHomeDto){
        System.out.println("首页");

//        ResponseResult load = apArticleService.load(ArticleConstants.LOADTYPE_LOAD_MORE, articleHomeDto);
        return apArticleService.load2(articleHomeDto, ArticleConstants.LOADTYPE_LOAD_MORE,true);


    }
    //**加载更多**
    @PostMapping("/loadmore")
    private ResponseResult loadmore(@RequestBody ArticleHomeDto articleHomeDto ){
         ResponseResult load = apArticleService.load(ArticleConstants.LOADTYPE_LOAD_NEW, articleHomeDto);
        return load ;
    }

    //**加载最新**
    @PostMapping("/loadnew")
    private ResponseResult loadnew(@RequestBody ArticleHomeDto articleHomeDto){
       ResponseResult load = apArticleService.load(ArticleConstants.LOADTYPE_LOAD_NEW, articleHomeDto);
        return load;
    }


    /*加载文章行为*/
 @PostMapping("/load_article_behavior")
    private ResponseResult load_article_behavior(@RequestBody ArticleInfoDto articleInfoDto){
     return  apArticleService.load_article_behavior(articleInfoDto);
 }

}

package com.heima.article.controller.v1;

import com.heima.article.service.ArticleCollectionService;
import com.heima.model.article.dtos.CollectionBehaviorDto;
import com.heima.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class ArticleCollectionController {

    @Autowired
    private ArticleCollectionService articleCollectionService;

    @PostMapping("/collection_behavior")
    private ResponseResult collection(@RequestBody CollectionBehaviorDto collectionBehaviorDto){
     return    articleCollectionService.collection(collectionBehaviorDto);
}
}

package com.heima.article.service;

import com.heima.model.article.dtos.CollectionBehaviorDto;
import com.heima.model.common.dtos.ResponseResult;

public interface ArticleCollectionService {
    ResponseResult collection(CollectionBehaviorDto collectionBehaviorDto);
}

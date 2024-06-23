package com.heima.search.service;

import com.heima.model.article.pojos.ApArticle;

public interface ArticleFreemarkerService {
    public void buildArticleToMinIO(ApArticle apArticle, String content);
}

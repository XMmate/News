package com.heima.article.test;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.heima.article.ArticleApplication;
import com.heima.article.mapper.ApArticleContentMapper;
import com.heima.article.mapper.ApArticleMapper;
import com.heima.article.service.ApArticleService;
import com.heima.file.service.FileStorageService;
import com.heima.model.article.pojos.ApArticle;
import com.heima.model.article.pojos.ApArticleContent;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = ArticleApplication.class)
@RunWith(SpringRunner.class)
public class ArticleFreemarkerTest {

    @Autowired
    private Configuration configuration;
    @Autowired
    private ApArticleContentMapper apArticleContentMapper;
    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private ApArticleMapper apArticleMapper;



    @Test
    public void createStaticUrlTest() throws IOException, TemplateException {
        List<ApArticle> apArticles = apArticleMapper.selectList(new QueryWrapper<>());
        for (ApArticle a:apArticles) {
            ApArticleContent apArticleContent=apArticleContentMapper.selectOne(Wrappers.<ApArticleContent>lambdaQuery().eq(ApArticleContent::getArticleId, a.getId()));
            if(apArticleContent != null && StringUtils.isNotBlank(apArticleContent.getContent())){
                //2.文章内容通过freemarker生成html文件
                StringWriter out = new StringWriter();
                Template template = configuration.getTemplate("article.ftl");

                Map<String, Object> params = new HashMap<>();
                params.put("content", JSONArray.parseArray(apArticleContent.getContent()));

                template.process(params, out);
                InputStream is = new ByteArrayInputStream(out.toString().getBytes());

                //3.把html文件上传到minio中
                String path = fileStorageService.uploadHtmlFile("", apArticleContent.getArticleId() + ".html", is);

                //4.修改ap_article表，保存static_url字段
                ApArticle article = new ApArticle();
                article.setId(apArticleContent.getArticleId());
                article.setStaticUrl(path);
                apArticleMapper.updateById(article);
        }


        }
    }
}

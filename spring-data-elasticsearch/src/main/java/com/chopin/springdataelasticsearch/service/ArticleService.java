package com.chopin.springdataelasticsearch.service;

import com.chopin.springdataelasticsearch.domain.Article;

import java.util.List;

/**
 * @Description: TODO
 * @Author chopin
 * @Date 2021/4/11 11:49 PM
 * @Version 1.0
 */
public interface ArticleService {
    List<Article> searchArticleByField(String keyword);
    List<Article> searchWithBoost();
    List<Article> searchWithMultipleFields(String content);
}

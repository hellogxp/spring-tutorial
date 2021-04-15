package com.chopin.springdataelasticsearch.repository;

import com.chopin.springdataelasticsearch.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Description: TODO
 * @Author chopin
 * @Date 2021/4/11 10:31 PM
 * @Version 1.0
 */
public interface ArticleRepository extends ElasticsearchRepository<Article, String> {
    /**
     *
     * @param title
     * @return
     */
    List<Article> findByTitle(String title);
}

package com.chopin.springdataelasticsearch.service.impl;

import com.chopin.springdataelasticsearch.domain.Article;
import com.chopin.springdataelasticsearch.repository.ArticleRepository;
import com.chopin.springdataelasticsearch.service.ArticleService;
import org.apache.lucene.search.BoostQuery;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: TODO
 * @Author chopin
 * @Date 2021/4/11 11:52 PM
 * @Version 1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public List<Article> searchArticleByField(String keyword) {
        List<Article> list;
        Query query = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchQuery("content", keyword)).build();
        SearchHits<Article> searchHits = elasticsearchRestTemplate.search(query, Article.class);
        for (int i = 0; i < searchHits.getTotalHits(); i++) {

        }
        return searchHits.stream().map(article -> article.getContent()).collect(Collectors.toList());
    }

    @Override
    public List<Article> searchWithBoost() {
        QueryBuilder queryBuilder = QueryBuilders.boostingQuery(QueryBuilders.termQuery("title", "London"),
                QueryBuilders.termQuery("title", "England")).negativeBoost(0.2f);
        Query query = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
        SearchHits<Article> searchHits = elasticsearchRestTemplate.search(query, Article.class);
        System.out.println(searchHits);
        return searchHits.stream().map(article -> article.getContent()).collect(Collectors.toList());
    }

    @Override
    public List<Article> searchWithMultipleFields(String content) {
        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(content, "title", "content");
        Query query = new NativeSearchQueryBuilder().withQuery(multiMatchQueryBuilder).build();
        SearchHits<Article> searchHits = elasticsearchRestTemplate.search(query, Article.class);
        return searchHits.stream().map(article -> article.getContent()).collect(Collectors.toList());
    }
}
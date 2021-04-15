package com.chopin.springdataelasticsearch;

import com.chopin.springdataelasticsearch.domain.Article;
import com.chopin.springdataelasticsearch.repository.ArticleRepository;
import com.chopin.springdataelasticsearch.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringDataElasticsearchApplicationTests {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    ArticleService articleService;

    @Test
    void contextLoads() {
        Article article = new Article();
        article.setId("2");
        article.setTitle("England");
        article.setContent("Thank you for taking part in ISC2020 Student Cluster");
        articleRepository.index(article);
    }

    @Test
    void getArticleByTitle() {
        List<Article> articleList = articleRepository.findByTitle("Scotland");
        articleList.forEach(article -> System.out.println(article.getTitle()));
    }

    @Test
    void getArticleByTitleKeyword() {
        List<Article> searchHits = articleService.searchArticleByField("brown dog");
    }

    @Test
    void getWithBoost() {
        List<Article> searchHits = articleService.searchWithBoost();
        searchHits.stream().forEach(System.out::println);
    }

    @Test
    void testWithMultipleField() {
        List<Article> articleList = articleService.searchWithMultipleFields("brown dog London");
        articleList.stream().forEach(System.out::println);
    }


}

package com.chopin.springdataelasticsearch.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Description: TODO
 * @Author chopin
 * @Date 2021/4/11 10:24 PM
 * @Version 1.0
 */
@Document(indexName = "blog", type = "article")
@Data
public class Article {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Text)
    private String content;
}
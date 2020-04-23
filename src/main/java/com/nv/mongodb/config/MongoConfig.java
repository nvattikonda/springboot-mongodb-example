package com.nv.mongodb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

import java.util.Map;

@Configuration
@ConfigurationProperties("mongodb")
@Data
public class MongoConfig {

    private Map<String, String> mapURL;

    @Primary
    @Bean(name = "analyticsMongoTemplate")
    public MongoTemplate analyticsTemplate() throws Exception {
        return new MongoTemplate(new SimpleMongoClientDbFactory(mapURL.get("sample_analytics")));
    }

    @Bean(name = "mflixMongoTemplate")
    public MongoTemplate mflixTemplate() throws Exception {
        String content = mapURL.get("content");
        return new MongoTemplate(new SimpleMongoClientDbFactory(mapURL.get("sample_mflix")));
    }
}

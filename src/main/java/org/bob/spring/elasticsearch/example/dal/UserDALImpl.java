package org.bob.spring.elasticsearch.example.dal;

import org.bob.spring.elasticsearch.example.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

import java.util.List;

public class UserDALImpl implements UserDAL {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${elasticsearch.index.name}")
    private String indexName;

    @Value("${elasticsearch.user.type}")
    private String userType;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public List<User> getAll() {
        SearchQuery getAllQuery = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery()).build();
        return elasticsearchTemplate.queryForList(getAllQuery, User.class);
    }
}

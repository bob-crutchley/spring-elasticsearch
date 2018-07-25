package org.bob.spring.elasticsearch.example.dal;

import org.bob.spring.elasticsearch.example.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, Long> {
}

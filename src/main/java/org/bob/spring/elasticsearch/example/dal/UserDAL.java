package org.bob.spring.elasticsearch.example.dal;

import org.bob.spring.elasticsearch.example.model.User;

import java.util.List;

public interface UserDAL {
    List<User> getAll();
}

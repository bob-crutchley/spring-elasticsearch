package org.bob.spring.elasticsearch.example;

import org.bob.spring.elasticsearch.example.dal.UserRepository;
import org.bob.spring.elasticsearch.example.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserDataController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/user/all")
    public List<User> getAll() {
        log.info("getting all users. total {}", userRepository.count());
        List<User> target = new ArrayList<>();
        userRepository.findAll().forEach(target::add);
        return target;
    }

    @RequestMapping("/user/save")
    public User save(@RequestBody User user) {
        log.info("adding a new user: {}", user.toString());
        return userRepository.save(user);
    }
}

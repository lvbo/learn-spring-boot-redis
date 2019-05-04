package io.github.lvbo.learn.spring.boot.redis.controller;

import io.github.lvbo.learn.spring.boot.redis.domain.User;
import io.github.lvbo.learn.spring.boot.redis.service.RedisStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisUserURLController {

    @Autowired
    private RedisStringService redisStringService;


    @PostMapping(value = "/v1/redis_user_url")
    public String create(String username, String url) {
        redisStringService.create(username, url);
        return "{username:" + username + ", url:" + url + "}";
    }

    @PutMapping(value = "/v1/redis_user_url")
    public String update(String username, String url) {
        redisStringService.update(username, url);
        return "{username:" + username + ", url:" + url + "}";
    }

    @DeleteMapping(value = "/v1/redis_user_url")
    public String delete(String username) {
        redisStringService.delete(username);
        return "{}";
    }

    @GetMapping(value = "/v1/redis_user_url")
    public String get(String username) {
        String url = redisStringService.get(username);
        return "{" + url + "}";
    }

    @GetMapping(value = "/v1/user")
    public User getUser(@RequestHeader String name) {
        User user = new User();
        user.setId(1);
        user.setName(name);
        user.setPassword("ttttttdd");
        return user;
    }
}

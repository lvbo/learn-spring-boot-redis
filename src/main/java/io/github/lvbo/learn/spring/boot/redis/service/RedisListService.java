package io.github.lvbo.learn.spring.boot.redis.service;

import io.github.lvbo.learn.spring.boot.redis.domain.User;

import java.util.List;

public interface RedisListService {

    void create(String key, User user);
    List<User> get(String key, long start, long end);
    User pop(String key);
}

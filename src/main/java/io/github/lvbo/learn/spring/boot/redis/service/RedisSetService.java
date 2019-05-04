package io.github.lvbo.learn.spring.boot.redis.service;

import io.github.lvbo.learn.spring.boot.redis.domain.User;

import java.util.Set;

public interface RedisSetService {
    void create(String key, User user);
    User randomGet(String key);
    void deleteElement(String key, User user);

    Set<User> union(String key1, String key2);
}

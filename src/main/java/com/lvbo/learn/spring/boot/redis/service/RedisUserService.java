package com.lvbo.learn.spring.boot.redis.service;

import com.lvbo.learn.spring.boot.redis.domain.User;

public interface RedisUserService {
    void set(String key, User user);
    void delete(String key);
    User get(String key);
}

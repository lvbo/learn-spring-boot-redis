package com.lvbo.learn.spring.boot.redis.service;

public interface RedisStringService {
    void create(String username, String url);

    void update(String username, String url);

    void delete(String username);

    String get(String username);

    long incr(String key, long delta);
}

package io.github.lvbo.lsb.redis.service;

import io.github.lvbo.lsb.redis.domain.User;

import java.util.List;

public interface RedisListService {

    void create(String key, User user);
    List<User> get(String key, long start, long end);
    User pop(String key);
}

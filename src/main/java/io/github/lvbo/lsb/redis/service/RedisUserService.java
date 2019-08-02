package io.github.lvbo.lsb.redis.service;

import io.github.lvbo.lsb.redis.domain.User;

public interface RedisUserService {
    void set(String key, User user);
    void delete(String key);
    User get(String key);
}

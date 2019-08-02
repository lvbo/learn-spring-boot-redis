package io.github.lvbo.lsb.redis.service;

import io.github.lvbo.lsb.redis.domain.User;

import java.util.List;
import java.util.Map;

public interface RedisHashService {

    void createUser(String key, String field, User user);

    void createUsers(String key, List<User> users);

    Map getUsers(String key);
}

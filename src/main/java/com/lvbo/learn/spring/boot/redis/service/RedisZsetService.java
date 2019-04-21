package com.lvbo.learn.spring.boot.redis.service;

import com.lvbo.learn.spring.boot.redis.domain.User;

import java.util.Set;

public interface RedisZsetService {
    void create(String key, int score, User member);
    void deleteMember(String key, User member);
    long getRank(String key, User member);
    Set<User> getRangeByScore(String key, double min, double max);

    Set<User> getRange(String key, long start, long end);
}

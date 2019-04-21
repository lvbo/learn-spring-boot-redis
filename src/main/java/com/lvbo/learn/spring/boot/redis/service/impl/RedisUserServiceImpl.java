package com.lvbo.learn.spring.boot.redis.service.impl;

import com.lvbo.learn.spring.boot.redis.domain.User;
import com.lvbo.learn.spring.boot.redis.service.RedisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisUserServiceImpl implements RedisUserService {

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Override
    public void set(String key, User user) {
        redisTemplate.opsForValue().set(key, user);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public User get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}

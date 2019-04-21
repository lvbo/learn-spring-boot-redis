package com.lvbo.learn.spring.boot.redis.service.impl;


import com.lvbo.learn.spring.boot.redis.service.RedisStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisStringServiceImpl implements RedisStringService {

    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    public RedisStringServiceImpl(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void create(String username, String url) {
        stringRedisTemplate.opsForValue().set(username, url);
    }

    @Override
    public void update(String username, String url) {
        stringRedisTemplate.opsForValue().set(username, url);
    }

    @Override
    public void delete(String username) {
        stringRedisTemplate.delete(username);
    }

    @Override
    public String get(String username) {
        return stringRedisTemplate.opsForValue().get(username);
    }

    @Override
    public long incr(String key, long delta) {
        return stringRedisTemplate.opsForValue().increment(key, delta);
    }


}
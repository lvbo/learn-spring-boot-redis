package io.github.lvbo.learn.spring.boot.redis.service.impl;

import io.github.lvbo.learn.spring.boot.redis.domain.User;
import io.github.lvbo.learn.spring.boot.redis.service.RedisListService;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RedisListServiceImpl implements RedisListService {

    @Resource(name = "redisTemplate")
    private ListOperations<String, User> listOperations;

    @Override
    public void create(String key, User user) {
        listOperations.rightPush(key, user);
    }

    @Override
    public List<User> get(String key, long start, long end) {
        return listOperations.range( key, start, end);
    }

    @Override
    public User pop(String key) {
        return listOperations.leftPop(key);
    }
}

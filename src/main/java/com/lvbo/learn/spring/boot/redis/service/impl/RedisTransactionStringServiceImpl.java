package com.lvbo.learn.spring.boot.redis.service.impl;

import com.lvbo.learn.spring.boot.redis.service.RedisTransactionStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisTransactionStringServiceImpl implements RedisTransactionStringService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void setDiscard(String key, String value) {
        stringRedisTemplate.execute(new SessionCallback<List<Object>>() {
            @Override
            public List<Object> execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                operations.opsForValue().set(key, value);
                operations.discard();
                return null;
            }
        });
    }


    @Override
    public List<Object> setExc(String key1, String value1, String key2, String value2) {
        return stringRedisTemplate.execute(new SessionCallback<List<Object>>() {
            @Override
            public List<Object> execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                operations.opsForValue().set(key1, value1);
                operations.opsForValue().set(key2, value2);
                return operations.exec();
            }
        });
    }
}

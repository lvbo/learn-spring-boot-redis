package com.lvbo.learn.spring.boot.redis.service.impl;

import com.lvbo.learn.spring.boot.redis.service.RedisStringService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisStringServiceImplTest {

    @Autowired
    private RedisStringService redisStringService;

    @Test
    public void create() {
        redisStringService.create("lvbo", "http://www.lvbo.com");
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void get() {
    }
    @Test
    public void incr() {
       redisStringService.incr("number_1", 2);
    }
}
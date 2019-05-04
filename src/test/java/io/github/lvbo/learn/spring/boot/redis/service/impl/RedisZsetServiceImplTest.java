package io.github.lvbo.learn.spring.boot.redis.service.impl;

import io.github.lvbo.learn.spring.boot.redis.service.RedisZsetService;
import io.github.lvbo.learn.spring.boot.redis.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisZsetServiceImplTest {

    @Autowired
    private RedisZsetService redisZsetService;

    @Test
    public void create() {
        User user = new User();
        user.setId(2);
        user.setName("user 2");
        user.setPassword("ttttttdd");
        redisZsetService.create("lvbo_score", 300, user);
    }

    @Test
    public void deleteMember() {
        User user = new User();
        user.setId(1);
        user.setName("user 1");
        user.setPassword("ttttttdd");
        redisZsetService.deleteMember("lvbo_score", user);
    }

    @Test
    public void getRank() {
        User user = new User();
        user.setId(1);
        user.setName("user 1");
        user.setPassword("ttttttdd");
        System.out.println(redisZsetService.getRank("lvbo_score", user));
    }

    @Test
    public void getRangeByScore() {
        System.out.println(redisZsetService.getRangeByScore("lvbo_score", 10.0, 800.0));
    }

    @Test
    public void getRange() {
        System.out.println(redisZsetService.getRange("lvbo_score", 0, 0));
    }
}
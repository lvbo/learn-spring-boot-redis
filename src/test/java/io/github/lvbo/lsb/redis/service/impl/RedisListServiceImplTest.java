package io.github.lvbo.lsb.redis.service.impl;

import io.github.lvbo.lsb.redis.domain.User;
import io.github.lvbo.lsb.redis.service.RedisListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisListServiceImplTest {

    @Autowired
    private RedisListService redisListService;

    @Test
    public void create() {
        User user = new User();
        user.setId(1);
        user.setName("user 1");
        user.setPassword("ttttttdd");
        redisListService.create("lvbo_list", user);
    }

    @Test
    public void get() {
        System.out.println(redisListService.get("lvbo_list", 0, -1));
    }

    @Test
    public void pop() {
        System.out.println(redisListService.leftPop("lvbo_list"));
    }
}
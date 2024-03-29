package io.github.lvbo.lsb.redis.service.impl;

import io.github.lvbo.lsb.redis.domain.User;
import io.github.lvbo.lsb.redis.service.RedisUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUserServiceImplTest {

    @Autowired
    private RedisUserService redisUserService;

    @Test
    public void set() {
        User user = new User();
        user.setId(1);
        user.setName("user 1");
        user.setPassword("ttttttdd");
       redisUserService.set("user_1", user);
    }

    @Test
    public void delete() {
        redisUserService.delete("user_1");
    }

    @Test
    public void get() {
        System.out.println(redisUserService.get("user_1"));
    }
}
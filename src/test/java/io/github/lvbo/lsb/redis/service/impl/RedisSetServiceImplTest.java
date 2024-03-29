package io.github.lvbo.lsb.redis.service.impl;

import io.github.lvbo.lsb.redis.domain.User;
import io.github.lvbo.lsb.redis.service.RedisSetService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisSetServiceImplTest {

    @Autowired
    private RedisSetService redisSetService;

    @Test
    public void create() {
        User user = new User();
        user.setId(2);
        user.setName("user 2");
        user.setPassword("ttttttdd");
        redisSetService.create("lvbo_set_2", user);

    }

    @Test
    public void randomGet() {
        System.out.println(redisSetService.randomGet("lvbo_set_2"));
    }

    @Test
    public void deleteElement() {
        User user = new User();
        user.setId(1);
        user.setName("user 1");
        user.setPassword("ttttttdd");
        redisSetService.deleteElement("lvbo_set_2", user);
    }

    @Test
    public void union() {
        User user = new User();
        user.setId(2);
        user.setName("user 2");
        user.setPassword("ttttttdd");
        redisSetService.create("lvbo_set", user);
        System.out.println(redisSetService.union("lvbo_set", "lvbo_set_2"));
    }
}
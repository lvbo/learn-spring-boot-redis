package io.github.lvbo.lsb.redis.service.impl;

import io.github.lvbo.lsb.redis.domain.User;
import io.github.lvbo.lsb.redis.service.RedisHashService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisHashServiceImplTest {

    @Autowired
    private RedisHashService redisHashService;

    @Test
    public void createUser() {
        User user = new User();
        user.setId(1);
        user.setName("user 1");
        user.setPassword("ttttttdd");
        redisHashService.createUser("lvbo_hash", "1", user);
    }

    @Test
    public void createUsers() {
        List<User> userList = new ArrayList<>(2);
        User user = new User();
        user.setId(2);
        user.setName("user 2");
        user.setPassword("ttttttdd");
        userList.add(user);

        user = new User();
        user.setId(3);
        user.setName("user 3");
        user.setPassword("ttttttdd");
        userList.add(user);
        redisHashService.createUsers("lvbo_2_hash", userList);
    }

    @Test
    public void getUsers() {
        System.out.println(redisHashService.getUsers("lvbo_2_hash"));
    }
}
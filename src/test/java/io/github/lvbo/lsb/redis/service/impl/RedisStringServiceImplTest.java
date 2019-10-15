package io.github.lvbo.lsb.redis.service.impl;

import io.github.lvbo.lsb.redis.service.RedisStringService;
import org.junit.Assert;
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
        redisStringService.update("lvbo", "http://githu.");
    }

    @Test
    public void delete() {
        redisStringService.delete("lvbo");
        String value = redisStringService.get("lvbo");
        Assert.assertEquals(null, value);
    }

    @Test
    public void get() {
        Assert.assertEquals("http://www.lvbo.com", redisStringService.get("lvbo"));
    }
    @Test
    public void incr() {
       long value = redisStringService.incr("number_1", 2);
       Assert.assertEquals(2, value);
    }
}
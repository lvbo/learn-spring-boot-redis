package io.github.lvbo.lsb.redis.service.impl;

import io.github.lvbo.lsb.redis.service.RedisTransactionStringService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTransactionStringServiceImplTest {

    @Autowired
    private RedisTransactionStringService redisTransactionStringService;

    @Test
    public void setDiscard() {
        redisTransactionStringService.setDiscard("tran", "2");
    }


    @Test
    public void setExc() {
        System.out.println(redisTransactionStringService.setExc("t1", "v1", "t2", "v2"));
    }
}
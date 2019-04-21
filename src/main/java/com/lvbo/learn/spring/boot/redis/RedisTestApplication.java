package com.lvbo.learn.spring.boot.redis;

import com.lvbo.learn.spring.boot.redis.util.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RedisTestApplication {


	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(RedisTestApplication.class, args);
		SpringContextUtil.setApplicationContext(ac);
	}
}

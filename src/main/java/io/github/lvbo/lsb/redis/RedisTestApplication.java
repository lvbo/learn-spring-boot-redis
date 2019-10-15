package io.github.lvbo.lsb.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RedisTestApplication {


	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(RedisTestApplication.class, args);
	}
}

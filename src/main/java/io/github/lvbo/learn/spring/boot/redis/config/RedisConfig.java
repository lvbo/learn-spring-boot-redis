package io.github.lvbo.learn.spring.boot.redis.config;


import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Value("${spring.redis.lettuce.pool.max-idle}")
    private int maxIdle;
    @Value("${spring.redis.lettuce.pool.min-idle}")
    private int minIdle;
    @Value("${spring.redis.lettuce.pool.max-active}")
    private int maxTotal;
    @Value("${spring.redis.lettuce.pool.max-wait}")
    private int maxWait;
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxWaitMillis(maxWait);

        LettucePoolingClientConfigurationBuilder clientConfiguration = LettucePoolingClientConfiguration.builder();
        clientConfiguration.poolConfig(poolConfig);

        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(host, port);
        redisStandaloneConfiguration.setPassword(RedisPassword.of(password));

        return new LettuceConnectionFactory(redisStandaloneConfiguration, clientConfiguration.build());
    }

//    @Bean
//    public StringRedisSerializer keySerializer() {
//        return new StringRedisSerializer();
//    }
//
//    @Bean
//    public GenericJackson2JsonRedisSerializer valueSerializer() {
//        return new GenericJackson2JsonRedisSerializer();
//    }
//
//    @Bean
//    public RedisTemplate redisTemplate() {
//        RedisTemplate redisTemplate = new RedisTemplate();
//        redisTemplate.setKeySerializer(keySerializer());
//        redisTemplate.setValueSerializer(valueSerializer());
//        redisTemplate.setConnectionFactory(redisConnectionFactory());
//        return redisTemplate;
//    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        GenericFastJsonRedisSerializer fastJsonRedisSerializer = new GenericFastJsonRedisSerializer();
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //设置默认的Serialize，包含 keySerializer & valueSerializer
//        redisTemplate.setDefaultSerializer(fastJsonRedisSerializer);

        //单独设置keySerializer
        redisTemplate.setKeySerializer(stringRedisSerializer);
        //单独设置valueSerializer
        redisTemplate.setValueSerializer(fastJsonRedisSerializer);
//
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
        return redisTemplate;
    }

}

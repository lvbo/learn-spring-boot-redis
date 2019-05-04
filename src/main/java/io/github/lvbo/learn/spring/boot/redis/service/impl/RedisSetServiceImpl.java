package io.github.lvbo.learn.spring.boot.redis.service.impl;

import io.github.lvbo.learn.spring.boot.redis.domain.User;
import io.github.lvbo.learn.spring.boot.redis.service.RedisSetService;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class RedisSetServiceImpl implements RedisSetService {

    @Resource(name = "redisTemplate")
    private SetOperations<String, User> setOperations;

    @Override
    public void create(String key, User user) {
        setOperations.add(key, user);
    }

    @Override
    public User randomGet(String key) {
        return setOperations.randomMember(key);
    }

    @Override
    public void deleteElement(String key, User user) {
        setOperations.remove(key, user);
    }

    @Override
    public Set<User> union(String key1, String key2) {
        return setOperations.union(key1, key2);
    }
}

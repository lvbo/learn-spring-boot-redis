package io.github.lvbo.lsb.redis.service.impl;

import io.github.lvbo.lsb.redis.domain.User;
import io.github.lvbo.lsb.redis.service.RedisHashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RedisHashServiceImpl implements RedisHashService {

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, User> hashOperations;

    @Override
    public void createUser(String key, String field, User user) {
        redisTemplate.opsForHash().put(key, field, user);
    }

    @Override
    public void createUsers(String key, List<User> users) {
        Map<String, User> userMap = new HashMap<>(users.size());
        for (User user : users) {
            userMap.put(user.getName(), user);
        }
        redisTemplate.opsForHash().putAll(key, userMap);
    }

    @Override
    public Map<String, User> getUsers(String key) {
//        return redisTemplate.opsForHash().entries(key);
        return hashOperations.entries(key);
    }
}

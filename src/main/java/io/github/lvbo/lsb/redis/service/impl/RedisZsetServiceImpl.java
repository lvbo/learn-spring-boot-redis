package io.github.lvbo.lsb.redis.service.impl;

import io.github.lvbo.lsb.redis.domain.User;
import io.github.lvbo.lsb.redis.service.RedisZsetService;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class RedisZsetServiceImpl implements RedisZsetService {

    @Resource(name = "redisTemplate")
    private ZSetOperations<String, User> zSetOperations;

    @Override
    public void create(String key, int score, User member) {
        zSetOperations.add(key, member, score);
    }

    @Override
    public void deleteMember(String key, User member) {
        zSetOperations.remove(key, member);
    }

    @Override
    public long getRank(String key, User member) {
        return zSetOperations.rank(key, member);
    }

    @Override
    public Set<User> getRangeByScore(String key, double min, double max) {
        return zSetOperations.rangeByScore(key, min, max);
    }

    @Override
    public Set<User> getRange(String key, long start, long end) {
        return zSetOperations.range(key, start, end);
    }
}

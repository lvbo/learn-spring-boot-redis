package io.github.lvbo.lsb.redis.service;

import java.util.List;

public interface RedisTransactionStringService {
    void setDiscard(String key, String value);

    List<Object> setExc(String key1, String value1, String key2, String value2);
}

package com.example.schedulertest.weather.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CacheService {

    private final RedisTemplate<String, String> redisTemplate;

    public void set(String key, Object value) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        try {
            ObjectMapper mapper = new ObjectMapper();
            valueOperations.set(key, mapper.writeValueAsString(value));
        } catch (Exception e) {
            log.error("[캐시 저장 에러]");
        }
    }

    public CacheService(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}

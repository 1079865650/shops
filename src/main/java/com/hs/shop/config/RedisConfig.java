package com.hs.shop.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author Foo
 * @version 1.0
 */

@Configuration
public class RedisConfig {

    @Bean
    RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> stringObjectRedisTemplate = new RedisTemplate<>();
        stringObjectRedisTemplate.setConnectionFactory(factory);

        stringObjectRedisTemplate.setKeySerializer(RedisSerializer.string());

        stringObjectRedisTemplate.setValueSerializer(RedisSerializer.json());

        return stringObjectRedisTemplate;

    }
}

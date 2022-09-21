package com.hs.shop;

import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class ShopApplicationTests {

    @Test
    void contextLoads() {
    }

    //ES 例子
    @Autowired
    RestHighLevelClient client;

    //Redis 例子1
    @Resource
    StringRedisTemplate stringRedisTemplate;
    //Redis 例子2
    @Resource
    RedisTemplate<String, Object> redisTemplate;


    //MQ例子
    @Autowired
    RabbitTemplate rabbitTemplate;


}

package com.example.rediscachedemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class CacheConfig {

    @Bean
    public RedisCacheManager cacheManager(
            RedisConnectionFactory redisConnectionFactory,
            ResourceLoader resourceLoader,
            ObjectMapper objectMapper) {
        RedisSerializer<Object> serializer = new GenericJackson2JsonRedisSerializer(objectMapper);
        //RedisSerializer<Object> serializer = RedisSerializer.java(resourceLoader.getClassLoader());

        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));

        return RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(config).build();
    }
}

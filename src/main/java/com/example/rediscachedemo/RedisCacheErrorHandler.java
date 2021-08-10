package com.example.rediscachedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.SimpleCacheErrorHandler;

/**
 * Deserialization (and other cache system related) errors have to be handled gracefully,
 * otherwise object in cache that cannot be deserialized (misconfigured Jackson, object structure change)
 * will never be loaded neither from cache nor from original source.
 */
@Slf4j
public class RedisCacheErrorHandler extends SimpleCacheErrorHandler {

    @Override
    public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
        log.error("Failed to load object with key [{}] from cache [{}]", key, cache.getName(), exception);
    }
}

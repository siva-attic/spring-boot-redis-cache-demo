# SpringBoot Redis Cache

```
> docker-compose up -d
> ./mvnw spring-boot:run
```

## Issue
Invoke http://localhost:8080/api/bookmarks/1 twice and you will get the following error:

```
java.lang.ClassCastException: class java.util.LinkedHashMap cannot be cast to class com.example.rediscachedemo.BookmarkDTO (java.util.LinkedHashMap is in module java.base of loader 'bootstrap'; com.example.rediscachedemo.BookmarkDTO is in unnamed module of loader 'app')
	at com.example.rediscachedemo.BookmarkService$$EnhancerBySpringCGLIB$$d8594d86.getBookmarkById(<generated>) ~[classes/:na]
	at com.example.rediscachedemo.BookmarkController.getBookmarkById(BookmarkController.java:19) ~[classes/:na]
```

In CacheConfig.java if you use `JdkSerializationRedisSerializer` instead of `GenericJackson2JsonRedisSerializer` it is working fine.

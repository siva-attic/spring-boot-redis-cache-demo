package com.example.rediscachedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class BookmarkService {

    @Cacheable(value = "bookmark-by-id")
    public BookmarkDTO getBookmarkById(Long id) {
        log.info("Getting bookmark from DB for id:{}", id);
        BookmarkDTO dto = new BookmarkDTO();
        dto.setId(id);
        dto.setUrl("http://host.com/post-"+id);
        return dto;
    }
}

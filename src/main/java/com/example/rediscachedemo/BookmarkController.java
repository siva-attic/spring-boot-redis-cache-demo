package com.example.rediscachedemo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class BookmarkController {
    private final BookmarkService bookmarkService;

    @GetMapping("/bookmarks/{id}")
    public BookmarkDTO getBookmarkById(@PathVariable Long id) {
        return bookmarkService.getBookmarkById(id);
    }
}

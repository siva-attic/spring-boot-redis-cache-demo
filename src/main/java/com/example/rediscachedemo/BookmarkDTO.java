package com.example.rediscachedemo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BookmarkDTO implements Serializable {
    private Long id;

    private String url;

    private String title;

    private Long categoryId;

    private String categoryName;

    private String categorySlug;

    @JsonProperty("created_user_id")
    private Long createdUserId;

    @JsonProperty("created_user_name")
    private String createdUserName;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}

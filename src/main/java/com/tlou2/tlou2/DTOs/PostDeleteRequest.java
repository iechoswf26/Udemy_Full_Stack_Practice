package com.tlou2.tlou2.DTOs;

public class PostDeleteRequest {
    private Long userId;
    private Long postId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public PostDeleteRequest(Long userId, Long postId) {
        this.userId = userId;
        this.postId = postId;
    }
}

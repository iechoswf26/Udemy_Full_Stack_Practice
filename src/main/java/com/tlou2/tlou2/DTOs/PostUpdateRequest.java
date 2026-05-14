package com.tlou2.tlou2.DTOs;

public class PostUpdateRequest {
    private Long postId;
    private String post;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public PostUpdateRequest(Long postId, String post, Long userId) {
        this.postId = postId;
        this.post = post;
        this.userId = userId;
    }

    private Long userId;
}

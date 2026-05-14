package com.tlou2.tlou2.DTOs;

public class PostRequest {
    private String post;

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public PostRequest(String post) {
        this.post = post;
    }
}

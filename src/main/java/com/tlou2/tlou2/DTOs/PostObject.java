package com.tlou2.tlou2.DTOs;

import java.time.LocalDateTime;

public class PostObject {
    private Long id;
    private String post;
    private LocalDateTime postDateTime;
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public LocalDateTime getPostDateTime() {
        return postDateTime;
    }

    public void setPostDateTime(LocalDateTime postDateTime) {
        this.postDateTime = postDateTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PostObject(Long id, String post, LocalDateTime postDateTime, String username) {
        this.id = id;
        this.post = post;
        this.postDateTime = postDateTime;
        this.username = username;
    }
}

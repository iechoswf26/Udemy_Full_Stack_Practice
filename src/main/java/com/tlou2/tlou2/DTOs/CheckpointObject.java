package com.tlou2.tlou2.DTOs;

import java.util.List;

public class CheckpointObject {
    private String description;
    private Long id;
    private String imageData;
    private String question;
    private String title;
    private List<PostObject> posts;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PostObject> getPosts() {
        return posts;
    }

    public void setPosts(List<PostObject> posts) {
        this.posts = posts;
    }

    public CheckpointObject(String description, Long id, String imageData, String question, String title, List<PostObject> posts) {
        this.description = description;
        this.id = id;
        this.imageData = imageData;
        this.question = question;
        this.title = title;
        this.posts = posts;
    }
}

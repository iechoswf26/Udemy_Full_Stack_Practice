package com.tlou2.tlou2.DTOs;

import java.util.List;

public class ChapterObject {
    private Long id;
    private String description;
    private String title;

    private List<CheckpointObject> checkpoints;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CheckpointObject> getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(List<CheckpointObject> checkpoints) {
        this.checkpoints = checkpoints;
    }

    public ChapterObject(Long id, String description, String title, List<CheckpointObject> checkpoints) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.checkpoints = checkpoints;
    }
}

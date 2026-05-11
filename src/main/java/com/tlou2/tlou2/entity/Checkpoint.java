/*
Package name is required and is explicitly declared at the top of the Java file. Uses reverse domain name: com.yourcompany.project.module.
 */
package com.tlou2.tlou2.entity;

// Required for all JPA annotations (@Entity, @Table, @Id, etc.)
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;


// Annotations
@Table(name = "checkpoint") // JPA - Specifies database table name. "User" is a keyword and therefore is invalid syntax. Change to "users."
@Entity // Marks class as JPA Entity
public class Checkpoint {
    @Id // Field: id. Purpose: Marks field as primary key of table.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tells database to auto-generate ID (auto-increment column).
    private Long id; // Column/field name.

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String question;

    @Column (name="image_data", nullable = false, columnDefinition = "TEXT")
    private String imageData;

    @ManyToOne(fetch = FetchType.LAZY) //Many Checkpoints to One Chapter
    @JoinColumn(name = "chapter_id")
    @JsonIgnore
    private Chapter chapter; // Every Chapter object holds reference to many Checkpoint objects.

    @OneToMany (mappedBy = "checkpoint") // One Checkpoint to Many Posts
    private List<Post> posts;

    // Empty constructor
    public Checkpoint() {
    }

    // Constructor for the Checkpoint Entity without ID.
    public Checkpoint(String title, String description, String question, String imageData, Chapter chapter, List<Post> posts) {
        this.title = title;
        this.description = description;
        this.question = question;
        this.imageData = imageData;
        this.chapter = chapter;
        this.posts = posts;
    }

    // Getters and Setters for Checkpoint Entity
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}

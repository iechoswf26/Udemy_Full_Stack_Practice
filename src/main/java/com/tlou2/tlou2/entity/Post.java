/*
Package name is required and is explicitly declared at the top of the Java file. Uses reverse domain name: com.yourcompany.project.module.
 */
package com.tlou2.tlou2.entity;

// Required for all JPA annotations (@Entity, @Table, @Id, etc.)
import jakarta.persistence.*;

import java.time.LocalDateTime;

// Annotations
@Entity // Marks class as JPA Entity
@Table(name = "post") // JPA - Specifies database table name. "User" is a keyword and therefore is invalid syntax. Change to "users."
public class Post {
    @Id // Field: id. Purpose: Marks field as primary key of table.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tells database to auto-generate ID (auto-increment column).
    private Long id; // Column/field name.

    @Column(nullable = false, columnDefinition = "TEXT")
    private String post;

    @Column(name="posted_date_time", nullable=false) // Maps the Java field postedDateTime to the database column posted_date_time. Useful when you want snake_case in DB and camelCase in Java.
    private LocalDateTime postedDateTime;

    @ManyToOne // Many Posts to One User
    @JoinColumn(name = "user_id") // Foreign key in post table.
    private User user; // Every User objects holds reference to list of many Post objects.

    @ManyToOne // Many Posts to One Checkpoint
    @JoinColumn(name = "checkpoint_id") // Foreign key in post table.
    private Checkpoint checkpoint;


    // Empty Constructor for Post
    public Post() {
    }

    // Constructor for Post without ID.
    public Post(String post, LocalDateTime postedDateTime, User user, Checkpoint checkpoint) {
        this.post = post;
        this.postedDateTime = postedDateTime;
        this.user = user;
        this.checkpoint = checkpoint;
    }

    // Setters and Getters for Post.
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

    public LocalDateTime getPostedDateTime() {
        return postedDateTime;
    }

    public void setPostedDateTime(LocalDateTime postedDateTime) {
        this.postedDateTime = postedDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Checkpoint getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(Checkpoint checkpoint) {
        this.checkpoint = checkpoint;
    }
}

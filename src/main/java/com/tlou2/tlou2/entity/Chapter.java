/*
Package name is required and is explicitly declared at the top of the Java file. Uses reverse domain name: com.yourcompany.project.module.
 */
package com.tlou2.tlou2.entity;

// Required for all JPA annotations (@Entity, @Table, @Id, etc.)
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

// Required for Java List class.
import java.util.List;

// Annotations
@Table(name = "chapter") // JPA - Specifies database table name. "User" is a keyword and therefore is invalid syntax. Change to "users."
@Entity // Marks class as JPA Entity
public class Chapter {
    @Id // Field: id. Purpose: Marks field as primary key of table.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tells database to auto-generate ID (auto-increment column).
    private Long id; // Column/field name.

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;


    @OneToMany(mappedBy = "chapter") // One Chapter to Many Checkpoints
    private List<Checkpoint> checkpoints; // Every Chapter objects holds reference to a list of many Checkpoint objects.

    // Empty constructor for Chapter Entity.
    public Chapter() {
    }

    // Constructor for Chapter Entity without ID.
    public Chapter(String title, List<Checkpoint> checkpoints, String description) {
        this.title = title;
        this.checkpoints = checkpoints;
        this.description = description;

    }

    // Setters and Getters for Chapter Entity
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

    public List<Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(List<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }
}
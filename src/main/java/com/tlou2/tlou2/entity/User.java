/*
Package name is required and is explicitly declared at the top of the Java file. Uses reverse domain name: com.yourcompany.project.module.
 */
package com.tlou2.tlou2.entity;

// Required for all JPA annotations (@Entity, @Table, @Id, etc.)
import jakarta.persistence.*;

// Required for Java time class for date.
import java.time.LocalDate;

// Required for Java List class.
import java.util.List;

// Annotations
@Table(name = "users") // JPA - Specifies database table name. "User" is a keyword and therefore is invalid syntax. Change to "users."
@Entity // Marks class as JPA Entity
public class User {
    @Id // Field: id. Purpose: Marks field as primary key of table.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tells database to auto-generate ID (auto-increment column).
    private Long id; // Column/field name.

    @Column(unique = true, nullable = false) // Defines column constraints: prevents multiple users from registering with same username, cannot be null, max length 255 characters (default is 255; not shown).
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false, columnDefinition = "DATE")// DOB constraint
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user") // One User to Many Posts
    private List<Post> posts; // Every User object holds reference to a list of many Post objects.

    // Create empty constructor for User.
    public User() {
    }

    // Create User constructor without the id.
    public User(String username, String email, LocalDate birthDate) {
        this.username = username;
        this.email = email;
        this.birthDate = birthDate;

    }

    // Setters and Getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}

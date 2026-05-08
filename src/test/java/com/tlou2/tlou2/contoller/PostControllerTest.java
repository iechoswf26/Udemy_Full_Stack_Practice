/* Package name is required and is explicitly declared at the top of the Java file.
Uses reverse domain name: com.yourcompany.project.module. */
package com.tlou2.tlou2.contoller;

import com.tlou2.tlou2.controller.PostController;
import com.tlou2.tlou2.entity.Chapter;
import com.tlou2.tlou2.entity.Checkpoint;
import com.tlou2.tlou2.entity.Post;
import com.tlou2.tlou2.entity.User;
import com.tlou2.tlou2.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@WebMvcTest(PostController.class) //@WebMvcTest: Tests Controller of Spring Boot app.
class PostControllerTest {
    @Autowired // Spring auto-injects required dependencies (beans) at runtime.
    MockMvc mockMvc; // MockMvc: Simulates HTTP requests without starting real server.

    @Autowired
    ObjectMapper objectMapper; // ObjectMapper: Creates objects and fills object with data.

    @MockitoBean // @MockitoBean: Swaps a real bean with Mockito mock in tests.
    PostService postService;

    //Initializing mocks to use in tests.
    Post post1;
    Post post2;
    User testUser;
    Checkpoint testCheckpoint;
    Chapter testChapter;

    //Create array that will hold multiple Post objects during tests.
    List<Post> posts = new ArrayList<>();

    // Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
    @BeforeEach
    void setUp() {

        testUser = new User(
                "TLOU2_Forever",
                "TLOU2_Forever@gmail.com",
                LocalDate.of(2000, 10, 1)
        );

        testCheckpoint = new Checkpoint (
                "1.1 Prologue",
                "The Last of Us Part II opens with Joel recounting the events of the first game to Tommy, including how he saved Ellie and lied about the Fireflies.",
                "Should Joel have lied to Ellie about the Fireflies, or did that decision make everything that followed inevitable?",
                "https://imgur.com/29gUUyR",
                testChapter,
                posts
        );

        post1 = new Post (
                "Ellie should let herself grieve.",
                LocalDateTime.of(2026, 5, 7, 14, 50, 0),
                testUser,
                testCheckpoint
        );
        post1.setId(1L);

        post2 = new Post (
                "Joel and Tommy should've known better than to stay with a group a strangers.",
                LocalDateTime.of(2026, 2, 26, 22, 30, 0),
                testUser,
                testCheckpoint
        );
        post2.setId(2L);

        posts = new ArrayList<>(List.of(post1, post2));
    }


    @Test
    void shouldSaveANewPost() throws Exception {
        //Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
        when(postService.savePost(any(Post.class))).thenReturn(post1); // "Whenever savePost() method is called on postService (with any Post object as input), return post1."

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        mockMvc.perform(post("/api/v1/post") // Simulates POST request to endpoint /api/v1/post.
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(post1))) // Sends post1 object as JSON in request body.
                .andExpect(status().isCreated()); // (HTTP Status): Checks that HTTP response status is 201 created.

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        verify(postService, times(1)).savePost(any(Post.class)); // (Service Interaction): Confirms that the controller called postService.savePost() exactly once.

    }

    @Test
    void shouldFindAllPostsByCheckpointId() throws Exception {
        //Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
        when(postService.findAllPostsByCheckpointId(anyLong())).thenReturn(posts);

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        mockMvc.perform(get("/api/v1/post/checkpoint/id/")
                        .param("id", Long.toString(1L))
                        .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.size()").value(posts.size()));

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        verify(postService).findAllPostsByCheckpointId(anyLong());

    }

    @Test
    void shouldUpdateAPost () throws Exception {
        //Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
        when(postService.updatePost(post2)).thenReturn(post2);

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        mockMvc.perform(put("/api/v1/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(post2)))
                .andExpect(status().isOk());

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        verify(postService).updatePost(any(Post.class));
    }

    @Test
    void shouldDeleteExistingPost() throws Exception {
        //Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
        doNothing().when(postService).deletePostById(post2.getId());

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        mockMvc.perform(delete("/api/v1/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(post2.getId())))
                .andExpect(status().isOk());

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        verify(postService).deletePostById(post2.getId());

    }



}



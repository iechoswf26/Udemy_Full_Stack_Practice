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
        when(postService.findAllPostsByCheckpointId(anyLong())).thenReturn(posts); // When the postService uses findAllPostsByCheckpointId using any ID, then return posts.

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        mockMvc.perform(get("/api/v1/post/checkpoint/id/") // Simulates GET request to endpoint /api/v1/post/checkpoint/id/.
                        .param("id", Long.toString(1L)) // Adds request parameter id=1 to URL. Equivalent to calling GET /api/v1/post/checkpoint/id/?id=1.
                        .contentType(MediaType.APPLICATION_JSON_VALUE)) // Content-Type header of HTTP request. Actual value is "application/json." Simpler words: Send request in JSON format.
                .andExpect(status().is2xxSuccessful()) // Checks that the HTTP response status is in the 2xx range (e.g. 200 OK).
                .andExpect(jsonPath("$.size()").value(posts.size())); // Checks the JSON response body. $.size() means "size of root JSON array" should equal number of posts in posts list.

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        verify(postService).findAllPostsByCheckpointId(anyLong()); //Verifies that the postService.findAllPostsByCheckpointId() method was called at least once with any Long value.

    }

    @Test
    void shouldUpdateAPost () throws Exception {
        //Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
        when(postService.updatePost(post2)).thenReturn(post2); // When the postService uses updatePost() method to update post2, return post2.

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        mockMvc.perform(put("/api/v1/post") // Simulates PUT request to endpoint /api/v1/post."
                .contentType(MediaType.APPLICATION_JSON) // Content-Type: header of HTTP request. Actual value: "application/json." Meaning: Send request in JSON format.
                .content(objectMapper.writeValueAsString(post2))) // Sends data (request body). objectMapper: converts Java objects to JSON. writeValueAsString(someObject): converts Java object into JSON string. .content(...): Adds JSON string as body of HTTP request.
                .andExpect(status().isOk()); // (HTTP Status): Standard HTTP response status for successful HTTP requests.

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        verify(postService).updatePost(any(Post.class)); // Verify that the postService updates any post using updatePost() method.
    }

    @Test
    void shouldDeleteExistingPost() throws Exception {
        //Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
        doNothing().when(postService).deletePostById(post2.getId()); // "When deletePostById() is called on PostService with post2's ID, do nothing."

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        mockMvc.perform(delete("/api/v1/post") // Simulates DELTE request to endpoint /api/v1/post.
                .contentType(MediaType.APPLICATION_JSON) // Content-Type: header of HTTP request. Actual value: "application/json." Meaning: Send request in JSON format.
                .content(objectMapper.writeValueAsString(post2.getId()))) // Sends data (request body). objectMapper: converts Java object to JSON. writeValueAsString(): converts Java object into JSON string. .content(...): Adds JSON string as body of HTTP request.
                .andExpect(status().isOk()); // (HTTP Status): Standard HTTP response status for successful HTTP requests.

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        verify(postService).deletePostById(post2.getId()); // Verify that the postService uses the deletePostById() method to identify post2 by its ID for deletion.

    }



}



/* Package name is required and is explicitly declared at the top of the Java file.
Uses reverse domain name: com.yourcompany.project.module. */
package com.tlou2.tlou2.service;

import com.tlou2.tlou2.entity.Chapter;
import com.tlou2.tlou2.entity.Checkpoint;
import com.tlou2.tlou2.entity.Post;
import com.tlou2.tlou2.entity.User;
import com.tlou2.tlou2.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // @ExtendWith(MockitoExtension.class): Enable Mockito to use mocks in test.
class PostServiceTest {

    //@Mock: Create fake postRepository (mock).
    @Mock
    private PostRepository postRepository;

    //@InjectMocks: Inject postRepository (mock) into real PostService.
    @InjectMocks
    private PostService postService;

    @Captor
    ArgumentCaptor<Post> captor = ArgumentCaptor.forClass(Post.class);

    //Initializing mock posts to use in tests - accessible in all test methods.
    User testUser;
    Checkpoint testCheckpoint;
    Chapter testChapter;
    Post post1;
    Post post2;
    Post deletedPost;

    // Create an array that will hold multiple Post objects during tests.
    List<Post> posts = new ArrayList<>();

    // Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
    @BeforeEach
    void setUp() {

        // MockitoAnnotations.openMocks(this);
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

        deletedPost = new Post (
                "Joel and Tommy should've known better than to stay with a group a strangers.",
                LocalDateTime.of(2026, 2, 26, 22, 30, 0),
                testUser,
                testCheckpoint
        );
    }

    @Test
    void shouldSaveANewPost() {
        //Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
        when(postRepository.save(post1)).thenReturn(post1); // "When the save(post1) method is called in postRepository, return post1."

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        Post result = postService.savePost(post1); // "Call actual Service method to save post1."

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getPost()).isEqualTo("Ellie should let herself grieve.");
        assertThat(result.getPostedDateTime()).isEqualTo(post1.getPostedDateTime());

        // Check associated entities by comparing meaningful fields (safer than comparing full objects).
        assertThat(result.getUser().getUsername()).isEqualTo(testUser.getUsername());
        assertThat(result.getCheckpoint().getId()).isEqualTo(testCheckpoint.getId());

        verify(postRepository, only()).save(post1); // postRepository was called exactly once with correct post.
    }

    @Test
    void shouldFindAllPostsByCheckpointId() {
        //Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
        when(postRepository.findAllByCheckpointId(anyLong())).thenReturn(posts); // "When the findAllByCheckpointId(anyLong()) is called on the postRepository, then return posts."

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        List<Post> actualPosts = postService.findAllPostsByCheckpointId(1L); // postService uses findAllPostsByCheckpointId() method to find all posts with ID (1L) and stores them as a list of posts called actualPosts.

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        assertThat(actualPosts).isNotEmpty();
        assertThat(actualPosts).hasSize(2);
        assertThat(actualPosts).isEqualTo(posts);

        verify(postRepository, times(1)).findAllByCheckpointId(anyLong()); // Verify that the postRepository is called only once and uses the findAllByCheckpointId(anyLong()) method to locate all posts.
    }

    @Test
    void shouldUpdateAPost() {
        //Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
        when(postRepository.findById(anyLong())).thenReturn(Optional.of(post1)); // "When the findById(anyLong()) method is called on the postRepository, then return post1 if it exists."
        when(postRepository.save(post1)).thenReturn(post1); // "When the save(post1) method is called on the postRepository, then return post1."

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        Post result = postService.updatePost(post1); // Calls the updatePost() method on postService, passing post1 as input and stores returned value in variable called result.

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        verify(postRepository, times(1)).findById(anyLong()); // Verify that the postRepository is only called once and uses the findById(anyLong()) method.
        verify(postRepository, times(1)).save(any(Post.class)); // Verify that the postRepository is only called once and uses the save(any(Post.class)) method.

    }

    @Test
    void shouldDeleteExistingPost() {
        //Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
        deletedPost.setId(1L); // Set the ID of deletedPost to 1L.
        when(postRepository.findById(deletedPost.getId())).thenReturn(Optional.of(deletedPost)); // "When the findById(deletedPost.getId()) method is called on the postRepository, return deletedPost wrapped in Optional."
        doNothing().when(postRepository).deleteById(deletedPost.getId()); // "When deleteById(1) is called, do not return anything."

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        postService.deletePostById(deletedPost.getId()); // Calls the real deletePostById() method in PostService with ID of 1.

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        verify(postRepository, times(1)).findById(anyLong()); // Verify that the postRepository is only called once to find a post by any ID.
        verify(postRepository, times(1)).deleteById(anyLong()); // Verify that the postRepository is called once to delete that post by any ID.

    }

}

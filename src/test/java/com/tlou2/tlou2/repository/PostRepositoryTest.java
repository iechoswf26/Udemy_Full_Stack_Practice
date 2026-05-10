/* Package name is required and is explicitly declared at the top of the Java file.
Uses reverse domain name: com.yourcompany.project.module. */
package com.tlou2.tlou2.repository;

import com.tlou2.tlou2.entity.Chapter;
import com.tlou2.tlou2.entity.Checkpoint;
import com.tlou2.tlou2.entity.Post;
import com.tlou2.tlou2.entity.User;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest // DataJpaTest: Tests Repository/Database layer of Spring boot app.
@ActiveProfiles("test")
// ActiveProfiles: When running test, use test configuration, not development (dev) or production (prod). SPring will load application.yml and load and apply application-test.yml (overriding where needed).
class PostRepositoryTest {

    @Autowired // Spring auto-injects required dependencies (beans) at runtime.
    PostRepository postRepository;

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

        post2 = new Post (
                "Joel and Tommy should've known better than to stay with a group a strangers.",
                LocalDateTime.of(2026, 2, 26, 22, 30, 0),
                testUser,
                testCheckpoint
        );

        deletedPost = new Post (
                "Joel and Tommy should've known better than to stay with a group a strangers.",
                LocalDateTime.of(2026, 2, 26, 22, 30, 0),
                testUser,
                testCheckpoint
        );

//        posts = new ArrayList<>(List.of(post1, post2));

    }

    @Test
    void shouldSaveANewPost() {
        // Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
        User testUser = new User();
        Checkpoint testCheckpoint = new Checkpoint();

        Post newPost = new Post( // Parameters and arguments should align with the attributes of the Post Entity.
                "Joel and Tommy shouldn't have saved Abby.",
                LocalDateTime.of(2026,5, 5, 22, 49, 0), // Year, Month, Day, Hour, Minute, Second
                testUser,
                testCheckpoint
        );

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        Post savedNewPost = postRepository.save(newPost); // Save a new post in the postRepository.
        Optional<Post> result = postRepository.findById(savedNewPost.getId()); // If there is a post, find it by referring to the saved post ID.

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        assertEquals("Joel and Tommy shouldn't have saved Abby.", result.get().getPost()); // Expectation: Get the post that matches the "fake" post listed above.
        assertThat(result.get().getPostedDateTime()).isEqualTo(newPost.getPostedDateTime()); // Assert/Verify: Repository will use getPostedDateTime method to retrieve the PostedDateTime from the "fake" new post listed above.
        assertThat(result.get().getUser()).isEqualTo(newPost.getUser()); // Assert/Verify: Repository will use getUser method to retrieve the User from the "fake" new post listed above.
        assertThat(result.get().getCheckpoint()).isEqualTo(newPost.getCheckpoint()); // Assert/Verify: Repository will use getCheckpoint method to retrieve the Checkpoint from the "fake" new post listed above.
        assertThat(result.get()).isEqualTo(newPost); // Assert/Verify: Repository will use get method to retrieve the new post from the "fake" new post listed above.
    }

    @Test
    void shouldFindAllPostsByCheckpointId() {
        // Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
        postRepository.saveAll(List.of(post1, post2));

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        List<Post> results = postRepository.findAllByCheckpointId(testCheckpoint.getId());
        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        assertThat(results).hasSize(2);
    }

    @Test
    void shouldUpdateAPost() {
        //Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
    }

    @Test
    void shouldDeleteExistingPost() {
        //Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
    }


}

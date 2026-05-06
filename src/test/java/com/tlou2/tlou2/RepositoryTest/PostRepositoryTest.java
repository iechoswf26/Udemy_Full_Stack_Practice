/* Package name is required and is explicitly declared at the top of the Java file.
Uses reverse domain name: com.yourcompany.project.module. */
package com.tlou2.tlou2.RepositoryTest;

import com.tlou2.tlou2.Entity.Checkpoint;
import com.tlou2.tlou2.Entity.Post;
import com.tlou2.tlou2.Entity.User;
import com.tlou2.tlou2.Repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
// DataJpaTest: Testing annotations that loads minimal application context with only JPA entities, Spring Data JPA repositories, and an embedded database.
public class PostRepositoryTest {

    @Autowired // Spring auto-injects required dependencies (beans) at runtime.
    PostRepository postRepository;

    @Test
    void shouldSaveANewPost() {
        // Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.

        User testUser = new User();
        testUser.setId(1L);

        Checkpoint testCheckpoint = new Checkpoint();
        testCheckpoint.setId(1L);

        Post newPost = new Post( // Parameters and arguments should align with the attributes of the Post Entity.
                "Joel and Tommy shouldn't have saved Abby.",
                LocalDateTime.of(2026,5, 5, 22, 49, 0), // Year, Month, Day, Hour, Minute, Second
                testUser,
                testCheckpoint
        );

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        Post savedNewPost = postRepository.save(newPost); // Save a new post in the postRepository.
        Optional<Post> result = postRepository.findById(savedNewPost.getId()); // If there is a post, find it by referring to the post ID.

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        assertEquals("Joel and Tommy shouldn't have saved Abby.", result.get().getPost()); // Expectation: Get the post that matches the "fake" post listed above.

        assertThat(result.get().getPostedDateTime()).isEqualTo(newPost.getPostedDateTime()); // Assert/Verify: Repository will use getPostedDateTime method to retrieve the PostedDateTime from the "fake" new post listed above.

        assertThat(result.get().getUser()).isEqualTo(newPost.getUser()); // Assert/Verify: Repository will use getUser method to retrieve the User from the "fake" new post listed above.

        assertThat(result.get().getCheckpoint()).isEqualTo(newPost.getCheckpoint()); // Assert/Verify: Repository will use getCheckpoint method to retrieve the Checkpoint from the "fake" new post listed above.

        assertThat(result.get()).isEqualTo(newPost); // Assert/Verify: Repository will use get method to retrieve the new post from the "fake" new post listed above.
    }


}

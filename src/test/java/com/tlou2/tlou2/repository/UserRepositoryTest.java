/* Package name is required and is explicitly declared at the top of the Java file.
Uses reverse domain name: com.yourcompany.project.module. */
package com.tlou2.tlou2.repository;

import com.tlou2.tlou2.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest // DataJpaTest: Tests Repository/Database layer of Spring boot app..
@ActiveProfiles("test")
/* ActiveProfiles: When running test, use test configuration, not development (dev) or production (prod).
Spring will load application.yml and load and apply application-test.yml (overriding where needed).
 */
public class UserRepositoryTest {

    @Autowired // Spring auto-injects required dependencies (beans) at runtime.
    UserRepository userRepository;

    @Test
    void shouldSaveANewUser() {
        // Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.

        User newUser = new User(
                "TeamFireflies123",
                "Sarah_Miller13@gmail.com",
                LocalDate.of(1995, 12, 1)
        );

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        User savedNewUser = userRepository.save(newUser); // Save a new user in the userRepository.
        Optional<User> result = userRepository.findById(savedNewUser.getId()); // If there is a post, find it by referring to the saved post ID.

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        assertThat(result.get().getUsername()).isEqualTo(newUser.getUsername()); // Assert/Verify: Repository will use getUsername method to retrieve username from "fake" new user account listed above.
        assertThat(result.get().getEmail()).isEqualTo(newUser.getEmail()); // Assert/Verify: Repository will use getEmail method to retrieve email from "fake" new user account listed above.
        assertThat(result.get().getBirthDate()).isEqualTo(newUser.getBirthDate()); // Assert/Verify: Repository will use getBirthDate method to retrieve birthdate from "fake" new user account listed above.
        assertThat(result.get()).isEqualTo(newUser); // Assert/Verify: Repository will use get method to retrieve the new user from the "fake" new user account listed above.

    }

}

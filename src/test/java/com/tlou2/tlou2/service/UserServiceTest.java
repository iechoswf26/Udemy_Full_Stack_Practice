/* Package name is required and is explicitly declared at the top of the Java file.
Uses reverse domain name: com.yourcompany.project.module. */
package com.tlou2.tlou2.service;

import com.tlou2.tlou2.entity.User;
import com.tlou2.tlou2.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // @ExtendWith(MockitoExtension.class): Enable Mockito to use mocks in test.
class UserServiceTest {

    // @Mock: Create fake userRepository (mock).
    @Mock
    private UserRepository userRepository;

    // @InjectMocks: Inject userRepository (mock) into real UserService.
    @InjectMocks
    private UserService userService;

    // Initializing mock user accounts to use in tests.
    User userAccount1;
    User userAccount2;

    /* Create an array that will hold multiple User objects during tests. May be used to test methods like:
    getAllUsers()
    findAllUsers()
    deleteUsers()
     */
    List<User> users = new ArrayList<>();

    // Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
    @BeforeEach
    void setUp() {
        userAccount1 = new User("TeamEllie_13", "ellie_williams@gmail.com", LocalDate.of(1988, 6, 1));
        userAccount1.setId(1L);
        userAccount2 = new User("TeamJoel_88", "joel_miller@gmail.com", LocalDate.of(1990, 10, 1));
        userAccount2.setId(2L);
    }

    @Test // "If I save user through service, do I get expected user back?"
    void shouldSaveANewUser() {
        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        when(userRepository.save(userAccount1)).thenReturn(userAccount1); // "If save(userAccount1) is called on fake repo, return userAccount1."
        User result = userService.saveUser(userAccount1); // "Call actual service method to save userAccount1."

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getUsername()).isEqualTo("TeamEllie_13");
        assertThat(result.getEmail()).isEqualTo("ellie_williams@gmail.com");
        assertThat(result.getBirthDate()).isEqualTo(LocalDate.of(1988, 6, 1));

        verify(userRepository, only()).save(userAccount1); // "Was save() called exactly once, and was it the ONLY interaction with the repo?"
    }

}

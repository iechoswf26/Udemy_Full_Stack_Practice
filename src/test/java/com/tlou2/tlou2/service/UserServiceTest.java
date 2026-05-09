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
import java.util.Optional;

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
    User deleteUser;

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

        deleteUser = new User("TeamJesse_00", "jesse@gmail.com", LocalDate.of(2005, 7, 1));
        deleteUser.setId(3L);
    }

    @Test // "If I save user through service, do I get expected user back?"
    void shouldSaveANewUser() {
        //Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
        when(userRepository.save(userAccount1)).thenReturn(userAccount1); // "If save(userAccount1) is called on fake repo, return userAccount1."

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        User result = userService.saveUser(userAccount1); // "Call actual service method to save userAccount1."

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getUsername()).isEqualTo("TeamEllie_13");
        assertThat(result.getEmail()).isEqualTo("ellie_williams@gmail.com");
        assertThat(result.getBirthDate()).isEqualTo(LocalDate.of(1988, 6, 1));

        verify(userRepository, only()).save(userAccount1); // "Was save() called exactly once, and was it the ONLY interaction with the repo?"
    }

    @Test
    void shouldFindUserById() {
        //Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
        when(userRepository.findById(1L)).thenReturn(Optional.of(userAccount1)); // Mock repository behavior: when findById(1L) is called, return userAccount1

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        User result = userService.findUserById(1L); // "Call actual service method under test." findUserById will be red if it doesn't exist in the UserService yet.

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        verify(userRepository, only()).findById(1L); // Verify repository interaction: findById(1L) was the only method called
        assertThat(result).isEqualTo(userAccount1); // Verify the returned user matches expected result.
    }

    @Test
    void shouldUpdateAUser() {
        //Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(userAccount1)); // When the findById(anyLong()) method is called on the userRepository, then return userAccount1 if it exists.
        when(userRepository.save(userAccount1)).thenReturn(userAccount1); // When the save() method is used on the userRepository, then save userAccount1.

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        User result = userService.updateUser(userAccount1); // Calls the updateUser() method on userService, passing userAccount1 as input and stores returned value in variable called result.

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        verify(userRepository, times(1)).findById(anyLong()); // Verifies that the userRepository was called once using the findById() method for any Long value.
        verify(userRepository, times(1)).save(userAccount1); // Verifies that the userRepository was called once using the save() method for userAccount1.

    }

    @Test
    void shouldDeleteExistingUser() {
        //Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
        doNothing().when(userRepository).deleteById(deleteUser.getId()); // "When deleteById(id) is called, do not do anything (and don't throw errors)."

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        userService.deleteUserById(deleteUser.getId()); // "Call actual service method under test." deleteUserById will be red if it doesn't exist in the UserService yet.

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        verify(userRepository, times(1)).deleteById(deleteUser.getId()); // userRepository was called exactly once with the correct ID.
    }


}

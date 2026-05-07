/* Package name is required and is explicitly declared at the top of the Java file.
Uses reverse domain name: com.yourcompany.project.module. */
package com.tlou2.tlou2.contoller;

import com.tlou2.tlou2.controller.UserController;
import com.tlou2.tlou2.entity.User;
import com.tlou2.tlou2.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(UserController.class) //@WebMvcTest: Tests Controller of Spring Boot app.
class UserControllerTest {

    @Autowired // Spring auto-injects required dependencies (beans) at runtime.
    private MockMvc mockMvc; // MockMvc: Simulates HTTP requests without starting real server.

    @Autowired
    private ObjectMapper objectMapper; // ObjectMapper: Creates objects and fills object with data.

    @MockitoBean // @MockitoBean: Swaps a real bean with a Mockito mock in tests.
    UserService userService;

    // Initializing mock user accounts to use in tests.
    User userAccount3;
    User userAccount4;

    // Create an array that will hold multiple User objects during tests.
    List<User> users = new ArrayList<>();

    // Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
    @BeforeEach
    void setUp() {
        userAccount3 = new User (
                "TeamAbby_13",
                "abbywins@gmail.com",
                LocalDate.of(1979, 3, 1)
        );
        userAccount3.setId(1L);

        userAccount4 = new User (
                "TeamDina_13",
                "Dina_the_Cool_Friend@gmail.com",
                LocalDate.of(2002, 4, 1)
        );
        userAccount4.setId(2L);


    }

    @Test
    void shouldSaveANewUser() throws Exception {
        //Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
        when(userService.saveUser(any(User.class))).thenReturn(userAccount3); // "Whenever saveUser() method is called on userService (with any User object as input), return userAccount3."

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        mockMvc.perform(post("/api/v1/user") // Simulates POST request to endpoint /api/v1/user.
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userAccount3))) // Sends userAccount3 object as JSON in request body.
                .andExpect(status().isCreated()); // (HTTP Status): Checks that HTTP response status is 201 created.

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        verify(userService, times(1)).saveUser(any(User.class)); // (Service Interaction): Confirms that the controller called userService.saveUser() exactly once.
    }

    @Test
    void shouldFindUserById() throws Exception {
        //Arrange - Meaning: Setup/prep test data. What you do here: Create objects, set initial values.
        when(userService.findUserById(1L)).thenReturn(userAccount3); // Mock service behavior: when findUserById(1L) is called, return userAccount3.

        String userJson = objectMapper.writeValueAsString(userAccount3); // Convert expected user object to JSON for response comparison.

        // Act - Meaning: Execute the action you want to test. What you do here: Call the method (e.g. findById()).
        mockMvc.perform(get("/api/v1/user/1")) // Simulates GET request to endpoint /api/v1/user/1.

                // Result Matchers
                .andExpect(status().isOk()) // (HTTP Status): Expect HTTP 200 OK status.
                .andExpect(content().json(userJson)); // (Response Body): Expect response body to match expected JSON.

        // Assert - Meaning: Verify the result is correct. What you do here: Check if the output matches expectations.
        verify(userService, only()).findUserById(1L); // (Service Interaction): Verify that the controller called userService.findByUserId() exactly once.

    }

}

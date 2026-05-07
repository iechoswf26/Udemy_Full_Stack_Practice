/* Package name is required and is explicitly declared at the top of the Java file.
Uses reverse domain name: com.yourcompany.project.module. */
package com.tlou2.tlou2.controller;

import com.tlou2.tlou2.entity.User;
import com.tlou2.tlou2.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController // @RestController: Processes incoming HTTP requests and returns data objects (rather than views).
@RequestMapping("/api/v1/user")
/* @RequestMapping:
- Map HTTP requests.
- Routes client requests to appropriate business logic.
- Works with GET, POST, PUT, DELETE. */
public class UserController {

    private final UserService userService; // Declares that UserController depends on UserService.

    public UserController(UserService userService) { // Create a constructor indicating that UserController receives UserService.
        this.userService = userService;
    }

    @PostMapping //@PostMapping: Send data to server to create new resource.
    @ResponseStatus(HttpStatus.CREATED) // @ResponseStatus: "When controller method finishes successfully, return HTTP Status Code 201 (Created) in the response."
    public User saveUser(@RequestBody User user) {
        /* saveUser() method
        @RequestBody User user: Converts JSON from request body into User object.
         */
        return userService.saveUser(user); // Calls saveUser() method on UserService.
    }



}

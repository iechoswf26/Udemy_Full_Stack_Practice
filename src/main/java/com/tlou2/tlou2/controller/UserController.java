/* Package name is required and is explicitly declared at the top of the Java file.
Uses reverse domain name: com.yourcompany.project.module. */
package com.tlou2.tlou2.controller;

import com.tlou2.tlou2.entity.User;
import com.tlou2.tlou2.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // @RestController: Processes incoming HTTP requests and returns data objects (rather than views).
@RequestMapping("/api/v1/user")
@CrossOrigin("*")
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

    @GetMapping("/{id}") // @GetMapping: Maps HTTP GET requests to this method (used to retrieve data).
    public ResponseEntity<User> findUserById(@PathVariable Long id) { // PathVariable extraction: Spring auto pulls 1 from the URL, converts it to Long, passes it into method.
        try {
            User user = userService.findUserById(id); // Controller calls service to fetch data.
            return ResponseEntity.ok(user); // Success path (user found): (1) HTTP Status: 200 OK. (2) Response Body: Controller converts user -> JSON.
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // If the Service throws an exception, (1) HTTP Status: 404 Not Found. (2) Response Body: empty.
        }
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("/{id}") // @DeleteMapping: Maps HTTP DELETE requests to this method.
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) { // PathVariable extraction: Spring auto pulls 1 from the URL, converts it to Long, passes it into method.
        try {
            userService.deleteUserById(id); // Controller calls service to delete data.
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Success path (404 No Content): (1) HTTP Status: 204 NO CONTENT. (2) Response Body: Standard for successful DELETE with no response body.
        } catch (IllegalArgumentException e) {
            // Service throws this when user is not found or ID is invalid.
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // If Service throws exception, (1) HTTP Status: 404 Not Found. (2) Response Body: N/A.
        }
    }



}

/* Package name is required and is explicitly declared at the top of the Java file.
Uses reverse domain name: com.yourcompany.project.module. */
package com.tlou2.tlou2.controller;

import com.tlou2.tlou2.entity.Post;
import com.tlou2.tlou2.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @RestController: Processes incoming HTTP requests and returns data objects (rather than views).
@RequestMapping("/api/v1/post")
/* @RequestMapping:
- Map HTTP requests.
- Routes client requests to appropriate business logic.
- Works with GET, POST, PUT, DELETE. */
public class PostController {

    private final PostService postService; // Declares that PostController depends on PostService.

    public PostController (PostService postService) { // Create constructor indicating that PostController receives postService.
        this.postService = postService;
    }

    @PostMapping // @PostMapping: Send data to server to create a new resource.
    @ResponseStatus(HttpStatus.CREATED) //@ResponseStatus: "When controller method finishes successfully, return HTTP Status Code 201 (Created) in the response."
    public Post savePost(@RequestBody Post post) {
        // savePost() method
        // @RequestBody Post post: Converts JSON from request body into Post object.
        return postService.savePost(post); // Calls savePost() method on PostService.
    }

    @GetMapping (value = "/checkpoint/id/", params = "id")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> findAllPostsByCheckpointId(@RequestParam Long id) {
        return postService.findAllPostsByCheckpointId(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Post updatePost(@RequestBody Post post) {
        return postService.updatePost(post);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteExistingPost(@RequestBody Long id) {
        postService.deletePostById(id);
    }

}

/* Package name is required and is explicitly declared at the top of the Java file.
Uses reverse domain name: com.yourcompany.project.module. */
package com.tlou2.tlou2.controller;

import com.tlou2.tlou2.DTOs.PostDeleteRequest;
import com.tlou2.tlou2.DTOs.PostRequest;
import com.tlou2.tlou2.DTOs.PostUpdateRequest;
import com.tlou2.tlou2.entity.Checkpoint;
import com.tlou2.tlou2.entity.Post;
import com.tlou2.tlou2.entity.User;
import com.tlou2.tlou2.service.CheckpointService;
import com.tlou2.tlou2.service.PostService;
import com.tlou2.tlou2.service.UserService;
import org.hibernate.annotations.DialectOverride;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController // @RestController: Processes incoming HTTP requests and returns data objects (rather than views).
@RequestMapping("/api/v1/post")
@CrossOrigin("*")
/* @RequestMapping:
- Map HTTP requests.
- Routes client requests to appropriate business logic.
- Works with GET, POST, PUT, DELETE. */
public class PostController {

    private final PostService postService; // Declares that PostController depends on PostService.
    private final UserService userService;
    private final CheckpointService checkpointService;

    public PostController (PostService postService, UserService userService, CheckpointService checkpointService) { // Create constructor indicating that PostController receives postService.
        this.postService = postService;
        this.userService = userService;
        this.checkpointService = checkpointService;
    }

    @PostMapping ("/{userId}/{checkpointId}")// @PostMapping: Send data to server to create a new resource.
    @ResponseStatus(HttpStatus.CREATED) //@ResponseStatus: "When controller method finishes successfully, return HTTP Status Code 201 (Created) in the response."
    public Post savePost(@RequestBody PostRequest post, @PathVariable Long userId, @PathVariable Long checkpointId) {
        User foundUser = this.userService.findUserById(userId);
        if (foundUser == null){
            return null;
        }
        Checkpoint checkpoint = this.checkpointService.findById(checkpointId);
        if (checkpoint == null){
            return null;
        }
        LocalDateTime timestamp = LocalDateTime.now();
        // savePost() method
        // @RequestBody Post post: Converts JSON from request body into Post object.
        return postService.savePost(new Post(post.getPost(), timestamp, foundUser, checkpoint)); // Calls savePost() method on PostService.
    }

    @GetMapping (value = "/checkpoint/id/", params = "id")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> findAllPostsByCheckpointId(@RequestParam Long id) {
        return postService.findAllPostsByCheckpointId(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Post updatePost(@RequestBody PostUpdateRequest post) {
        return postService.updatePost(post);
    }

    @DeleteMapping("/{userId}/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteExistingPost(@PathVariable Long userId, @PathVariable Long postId) {
        postService.deletePostById(userId, postId);
    }

}

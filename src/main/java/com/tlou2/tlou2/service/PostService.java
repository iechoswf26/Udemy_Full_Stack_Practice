/* Package name is required and is explicitly declared at the top of the Java file.
Uses reverse domain name: com.yourcompany.project.module. */
package com.tlou2.tlou2.service;

import com.tlou2.tlou2.entity.Post;
import com.tlou2.tlou2.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service // @Service: Instantiate PostService and make it available for dependency injection elsewhere.
public class PostService {

    private final PostRepository postRepository; // Declares that PostService depends on PostRepository.

    public PostService(PostRepository postRepository) {

    /* Spring performs dependency injection.
    (1) Spring creates PostRepository bean.
    (2) Spring creates PostService bean.
    (3) Spring passes repository into constructor.
    Summary: PostService receives repository.
     */
        this.postRepository = postRepository;
    }

    public Post savePost (Post post) {
        return postRepository.save(post);
    }

    public List<Post> findAllPostsByCheckpointId(Long checkpointId) {
        return postRepository.findAllByCheckpointId(checkpointId);
    }

    public Post updatePost(Post post) {
        Optional<Post> foundPost = postRepository.findById(post.getId());
        if (foundPost.isPresent()) {
            return postRepository.save(post);
        } else {
            return null;
        }

    }

}
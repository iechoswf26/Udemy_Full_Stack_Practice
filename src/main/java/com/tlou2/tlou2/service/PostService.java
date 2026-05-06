/* Package name is required and is explicitly declared at the top of the Java file.
Uses reverse domain name: com.yourcompany.project.module. */
package com.tlou2.tlou2.service;

import com.tlou2.tlou2.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service // @Service: Handles Class as a service Spring bean (dependency).
public class PostService {

    private final PostRepository postRepository; // Call the mock postRepository.


    public PostService(PostRepository postRepository) { // Pass
        this.postRepository = postRepository;
    }

}

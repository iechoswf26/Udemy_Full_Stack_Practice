/* Package name is required and is explicitly declared at the top of the Java file.
Uses reverse domain name: com.yourcompany.project.module. */
package com.tlou2.tlou2.service;

import com.tlou2.tlou2.repository.PostRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // @ExtendWith(MockitoExtension.class): Enable Mockito to use mocks in test.
class PostServiceTest {

    @Mock // Create fake postRepository (mock).
    private PostRepository postRepository;

    @InjectMocks // Inject postRepository (mock) into postService.
    private PostService postService;


}

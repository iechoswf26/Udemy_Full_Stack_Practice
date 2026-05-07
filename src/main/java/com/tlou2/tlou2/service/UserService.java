/* Package name is required and is explicitly declared at the top of the Java file.
Uses reverse domain name: com.yourcompany.project.module. */

package com.tlou2.tlou2.service;

import com.tlou2.tlou2.entity.User;
import com.tlou2.tlou2.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service // @Service: Instantiate UserService and make it available for dependency injection elsewhere.
public class UserService {

    private final UserRepository userRepository; // Declares that UserService depends on UserRepository.

    public UserService(UserRepository userRepository) {
        /* Spring performs dependency injection.
        (1) Spring creates PostRepository bean.
        (2) Spring creates PostService bean.
        (3) Spring passes repository into constructor.
        Summary: Create a constructor indicating that UserService receives repository.
        */
        this.userRepository = userRepository;
    }

    public User saveUser(User user) { // Save User entity by passing User object to the repository.
        return userRepository.save(user); // Tell the userRepository to save the user.
    }
}

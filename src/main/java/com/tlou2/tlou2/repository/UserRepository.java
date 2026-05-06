/* Package name is required and is explicitly declared at the top of the Java file.
Uses reverse domain name: com.yourcompany.project.module. */
package com.tlou2.tlou2.repository;

import com.tlou2.tlou2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // @Repository: Instantiate PostRepository and make it available for dependency injection elsewhere.
public interface UserRepository extends JpaRepository<User, Long> { //JpaRepository: Generic interface that extends into repository interfaces. Acquire 18 common methods (e.g. findById(id)).
// <Post, Long> Post is entity class that JpaRepository manages. Long is data type of primary key (@Id).


}


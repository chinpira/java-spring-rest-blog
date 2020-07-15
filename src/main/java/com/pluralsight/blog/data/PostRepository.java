package com.pluralsight.blog.data;

import com.pluralsight.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    // Spring enabled the custom search path /findByTitleContaining?title=... based on the title input and the return type
    // The @RestResource annotation allows us to provide an alias to the path (/containsTitle?title=... in this case)
    @RestResource(rel = "contains-title", path = "containsTitle")
    List<Post> findByTitleContaining(String title);

    List<Post> findByAuthor_Lastname(String lastname);
}
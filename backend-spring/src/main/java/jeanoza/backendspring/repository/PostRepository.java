package jeanoza.backendspring.repository;

import jeanoza.backendspring.model.Post;
import jeanoza.backendspring.model.post.PostDto;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post save(Post post);
    List<Post> findAll();

    Optional<Post> findById(Long id);
}

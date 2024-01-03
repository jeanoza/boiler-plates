package jeanoza.backendspring.repository;

import jakarta.persistence.EntityManager;
import jeanoza.backendspring.model.Post;
import jeanoza.backendspring.model.post.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository{
    private final EntityManager em;

    @Override
    public Post save(Post post) {
        em.persist(post);
        return post;
    }
    @Override
    public List<Post> findAll() {
        String jpql = "SELECT p FROM Post p JOIN fetch p.member m";
        return em.createQuery(jpql, Post.class).getResultList();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.ofNullable(em.find(Post.class, id));
    }

}

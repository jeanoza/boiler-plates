package jeanoza.backendspring.service;

import jeanoza.backendspring.model.Member;
import jeanoza.backendspring.model.Post;
import jeanoza.backendspring.model.post.CreatePostDto;
import jeanoza.backendspring.model.post.UpdatePostDto;
import jeanoza.backendspring.repository.MemberRepository;
import jeanoza.backendspring.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Post createPost(CreatePostDto createPostDto) {

        Member member = memberRepository
                .findById(createPostDto.getCreatedBy())
                .orElseThrow(
                        () -> new RuntimeException("No member corresponding to id")
                );

        Post post = new Post();
        post.setName(createPostDto.getName());
        post.setContent(createPostDto.getContent());
        post.setCreatedAt(LocalDate.now());
        post.setUpdatedAt(LocalDate.now());
        post.setMember(member);

        return postRepository.save(post);
    }

    public Post updatePost(Long id, UpdatePostDto updatePostDto) {
        Post oldPost = postRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("No post corresponding with this Id"));
//        Member member = memberRepository
//                .findById(updatePostDto.getCreatedBy())
//                .orElseThrow(
//                        () -> new RuntimeException("No member corresponding to id")
//                );

        updatePostDto.getName().ifPresent(oldPost::setName);
        updatePostDto.getContent().ifPresent(oldPost::setContent);

        return postRepository.save(oldPost);
    }

    public void deletePost(Long id) {

    }

    public Post getPost(Long id) {
        return null;
    }

    public List<Post> getPosts() {
        return null;
    }
}

package jeanoza.backendspring.service;

import jeanoza.backendspring.model.Member;
import jeanoza.backendspring.model.Post;
import jeanoza.backendspring.model.post.CreatePostDto;
import jeanoza.backendspring.model.post.UpdatePostDto;
import jeanoza.backendspring.repository.MemberRepository;
import jeanoza.backendspring.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Post createPost(CreatePostDto createPostDto, Long memberId) {

        Member member = memberRepository
                .findById(memberId)
                .orElseThrow(
                        () -> new RuntimeException("No member corresponding to id")
                );

        Post post = new Post();
        post.setName(createPostDto.getName());
        post.setContent(createPostDto.getContent());
        post.setMember(member);

        return postRepository.save(post);
    }

    @Transactional
    public Post updatePost(Long id, UpdatePostDto updatePostDto, Long memberId) {
        Post oldPost = postRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("No post corresponding with this Id"));

        Member member = memberRepository
                .findById(memberId)
                .orElseThrow(
                        () -> new RuntimeException("No member corresponding to id")
                );
        if (!member.getId().equals(oldPost.getMember().getId()))
            throw new RuntimeException("Member are not creator");

        updatePostDto.getName().ifPresent(oldPost::setName);
        updatePostDto.getContent().ifPresent(oldPost::setContent);
        oldPost.setUpdatedAt(LocalDateTime.now());

        return postRepository.save(oldPost);
    }

    public void deletePost(Long id) {

    }

    public Post getPost(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }
}

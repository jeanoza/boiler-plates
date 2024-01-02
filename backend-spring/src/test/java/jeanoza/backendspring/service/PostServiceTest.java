package jeanoza.backendspring.service;

import jeanoza.backendspring.model.Member;
import jeanoza.backendspring.model.Post;
import jeanoza.backendspring.model.post.CreatePostDto;
import jeanoza.backendspring.model.post.UpdatePostDto;
import jeanoza.backendspring.repository.MemberRepository;
import jeanoza.backendspring.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional(readOnly = true)
class PostServiceTest {
    @Autowired
    PostService postService;
    @Autowired
    PostRepository postRepository;
    @Autowired
    MemberRepository memberRepository;


    @Test
    @Transactional
    void createPost() {
        //given
        CreatePostDto createPostDto = new CreatePostDto();
        createPostDto.setCreatedBy(1L);
        createPostDto.setName("first blog");
        createPostDto.setContent("hello world");

        Member member = new Member();
        member.setName("jeanoza");
        memberRepository.save(member);

        //when
        Post result = postService.createPost(createPostDto);

        //then
        assertEquals(result.getName(), createPostDto.getName());
    }
    @Test
    @Transactional
    void createPostThrowError() {
        //given
        CreatePostDto createPostDto = new CreatePostDto();
        createPostDto.setCreatedBy(2L);
        createPostDto.setName("first blog");
        createPostDto.setContent("hello world");

        Member member = new Member();
        member.setName("jeanoza");
        memberRepository.save(member);
        //when
        RuntimeException e = assertThrows(RuntimeException.class, () -> {
            postService.createPost(createPostDto);
        });

        //then
        assertEquals(e.getMessage(), "No member corresponding to id");
    }

    @Test
    void updatePost() {
        UpdatePostDto updatePostDto = new UpdatePostDto();
        updatePostDto.setName();
    }

    @Test
    void deletePost() {
    }

    @Test
    void getPost() {
    }

    @Test
    void getPosts() {
    }
}
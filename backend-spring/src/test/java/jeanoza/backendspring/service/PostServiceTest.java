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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


//TODO: refactoring test code using beforeEach
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
        createPostDto.setName("first blog");
        createPostDto.setContent("hello world");

        Member member = new Member();
        member.setName("jeanoza");
        memberRepository.save(member);

        //when
        Post result = postService.createPost(createPostDto, member.getId());

        //then
        assertEquals(result.getName(), createPostDto.getName());
    }

    @Test
    @Transactional
    void createPostThrowError() {
        //given
        CreatePostDto createPostDto = new CreatePostDto();
        createPostDto.setName("first blog");
        createPostDto.setContent("hello world");

        Member member = new Member();
        member.setName("jeanoza");
        memberRepository.save(member);
        //when
        RuntimeException e = assertThrows(RuntimeException.class, () -> {
            postService.createPost(createPostDto, 2L);
        });

        //then
        assertEquals(e.getMessage(), "No member corresponding to id");
    }

    @Transactional
    @Test
    void updatePost() {
        //given
        CreatePostDto createPostDto = new CreatePostDto();
        createPostDto.setName("firstBlog");
        createPostDto.setContent("hello world");

        Member member = new Member();
        member.setName("jeanoza");
        memberRepository.save(member);

        Post oldPost = postService.createPost(createPostDto, member.getId());


        UpdatePostDto updatePostDto = new UpdatePostDto();
        updatePostDto.setName(Optional.of("second blog"));
        updatePostDto.setContent(Optional.of("Bonjour à tous!"));

        //when
        Post newPost = postService.updatePost(oldPost.getId(), updatePostDto, member.getId());

        //then
        assertEquals(oldPost.getId(), newPost.getId());
        assertNotEquals(createPostDto.getName(), newPost.getName());
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
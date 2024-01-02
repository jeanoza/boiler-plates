package jeanoza.backendspring.controller;

import jakarta.servlet.http.HttpServletRequest;
import jeanoza.backendspring.CookieUtils;
import jeanoza.backendspring.model.Post;
import jeanoza.backendspring.model.post.CreatePostDto;
import jeanoza.backendspring.model.post.UpdatePostDto;
import jeanoza.backendspring.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;


    @PostMapping
    public ResponseEntity<?> createPost(HttpServletRequest request, @RequestBody CreatePostDto createPostDto) {
        try {
            Long memberId = CookieUtils.getUserIdByCookie(request);
            postService.createPost(createPostDto, memberId);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Post created");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    //TODO: put guard
    @GetMapping
    public ResponseEntity<List<Post>> getPosts() {
        try {
            List<Post> posts = postService.getPosts();
            return ResponseEntity.ok().body(posts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    //TODO: put guard
    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable Long id) {
        return ResponseEntity.ok().body(postService.getPost(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePost(HttpServletRequest request, @PathVariable Long id, @RequestBody UpdatePostDto updatePostDto) {
        return null;
    }
}

package jeanoza.backendspring.controller;

import jeanoza.backendspring.model.Post;
import jeanoza.backendspring.model.post.CreatePostDto;
import jeanoza.backendspring.model.post.UpdatePostDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/posts")
public class PostController {

    @GetMapping("/")
    public ResponseEntity<?> getPosts() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/")
    public ResponseEntity<?> createPost(CreatePostDto createPostDto) {
        return null;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Long id, UpdatePostDto updatePostDto) {
        return null;
    }
}

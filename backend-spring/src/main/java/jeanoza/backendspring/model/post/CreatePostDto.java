package jeanoza.backendspring.model.post;

import lombok.Data;

@Data
public class CreatePostDto {
    private String name;
    private String content;
}

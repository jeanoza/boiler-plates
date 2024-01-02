package jeanoza.backendspring.model.post;

import lombok.Data;

@Data
public class CreatePostDto {
    private Long createdBy; //  remove this field when Guard is implemented
    private String name;
    private String content;
}

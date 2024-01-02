package jeanoza.backendspring.model.post;

import lombok.Data;

import java.util.Optional;

@Data
public class UpdatePostDto {
    private Optional<String> name;
    private Optional<String> content;
}

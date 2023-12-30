package jeanoza.backendspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String content;

    @CreatedBy
    private Long createdBy;

    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;

    public Post() {
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    public Post(String name, String content) {
        this();
        this.name = name;
        this.content = content;
    }

}

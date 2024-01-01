package jeanoza.backendspring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;

    @ManyToOne
    @JoinColumn(name = "createdBy")
    private Member member;

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

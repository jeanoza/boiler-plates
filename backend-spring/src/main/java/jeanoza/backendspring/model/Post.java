package jeanoza.backendspring.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String content;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name ="created_at")
    private LocalDateTime createdAt;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name ="updated_at")
    private LocalDateTime updatedAt;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name ="deleted_at")
    private LocalDateTime deletedAt;

    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "created_by")
//    @JsonIgnore
    @JsonManagedReference
    private Member member;

    public Post() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}

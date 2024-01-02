package jeanoza.backendspring.model.member;


import lombok.Data;

@Data
public class JoinFormDto {
    private String name;
    private String email;
    private String password;
}

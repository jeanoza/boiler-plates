package jeanoza.backendspring.model.member;


import lombok.Data;


@Data
public class LoginFormDto {
    private String email;
    private String password;
}

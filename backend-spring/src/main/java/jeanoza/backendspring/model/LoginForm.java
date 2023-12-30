package jeanoza.backendspring.model;


import lombok.*;


@Getter
@Setter
@ToString
public class LoginForm {
    private String email;
    private String password;
}

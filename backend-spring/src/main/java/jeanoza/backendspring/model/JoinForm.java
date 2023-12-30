package jeanoza.backendspring.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JoinForm {
    private String name;
    private String email;
    private String password;
}

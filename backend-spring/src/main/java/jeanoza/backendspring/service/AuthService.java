package jeanoza.backendspring.service;

import jeanoza.backendspring.model.JoinForm;
import jeanoza.backendspring.model.LoginForm;
import jeanoza.backendspring.model.Member;

public interface AuthService {

    Member join(JoinForm joinForm);
    Member login(LoginForm loginForm);
    void logout();

}

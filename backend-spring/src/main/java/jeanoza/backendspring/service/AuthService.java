package jeanoza.backendspring.service;

import jeanoza.backendspring.model.JoinForm;
import jeanoza.backendspring.model.LoginForm;

public interface AuthService {

    Long join(JoinForm joinForm);
    void login(LoginForm loginForm);
    void logout();

}

package jeanoza.backendspring.controller;

import jeanoza.backendspring.model.JoinForm;
import jeanoza.backendspring.model.LoginForm;
import jeanoza.backendspring.service.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthServiceImpl authServiceImpl;

    @GetMapping("")
    public ResponseEntity<String> getAuth() {
        return ResponseEntity.ok().body("getAuth");
    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> login(@RequestBody LoginForm loginForm) {
        authServiceImpl.login(loginForm);
        return ResponseEntity.ok().body("login");
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> join(@RequestBody JoinForm joinForm) {
        authServiceImpl.join(joinForm);
        return ResponseEntity.ok().body("join");
    }

}

package jeanoza.backendspring.controller;

import jeanoza.backendspring.model.JoinForm;
import jeanoza.backendspring.model.LoginForm;
import jeanoza.backendspring.model.Member;
import jeanoza.backendspring.service.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> login(@RequestBody LoginForm loginForm) {
        try {
            Member logged = authServiceImpl.login(loginForm);
            return ResponseEntity.ok(logged);
        } catch (RuntimeException e) {
            // Handle the specific exception or create a custom response for other exceptions
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> join(@RequestBody JoinForm joinForm) {
        try {
            Member joined = authServiceImpl.join(joinForm);
            return ResponseEntity.ok(joined);
        } catch (RuntimeException e) {
            // Handle the specific exception or create a custom response for other exceptions
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

}

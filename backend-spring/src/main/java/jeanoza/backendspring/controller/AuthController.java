package jeanoza.backendspring.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jeanoza.backendspring.CookieUtils;
import jeanoza.backendspring.model.member.JoinFormDto;
import jeanoza.backendspring.model.member.LoginFormDto;
import jeanoza.backendspring.model.Member;
import jeanoza.backendspring.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Optional;


//TODO : implement jwt and hash password
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @GetMapping
    public ResponseEntity<?> getAuth(HttpServletRequest request) {
        try {
            Long memberId = CookieUtils.getUserIdByCookie(request);
            return ResponseEntity.ok()
                    .body(authService.getMember(memberId));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/sign-out")
    public ResponseEntity<?> logout() {
        HttpHeaders headers = CookieUtils.createHeaderWithCookie("user_id", "", 0);
        return ResponseEntity.ok()
                .headers(headers)
                .body("Successful logged out");
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> login(@RequestBody LoginFormDto loginFormDto) {
        try {
            Member logged = authService.login(loginFormDto);
            //TODO: replace with jwt token after
            HttpHeaders headers = CookieUtils.createHeaderWithCookie("user_id", logged.getId().toString(), 3600);

            return ResponseEntity.ok()
                    .headers(headers)
                    .body("Successful logged in");
        } catch (RuntimeException e) {
            // Handle the specific exception or create a custom response for other exceptions
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        }
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> join(@RequestBody JoinFormDto joinFormDto) {
        try {
            Member joined = authService.join(joinFormDto);
            //TODO: replace with jwt token after
            HttpHeaders headers = CookieUtils.createHeaderWithCookie("user_id", joined.getId().toString(), 3600);

            return ResponseEntity.ok()
                    .headers(headers)
                    .body("Successful joined");
        } catch (RuntimeException e) {
            // Handle the specific exception or create a custom response for other exceptions
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        }
    }

}

package jeanoza.backendspring.service;

import jeanoza.backendspring.model.JoinForm;
import jeanoza.backendspring.model.LoginForm;
import jeanoza.backendspring.model.Member;
import jeanoza.backendspring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AuthServiceImplTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    AuthService authService;

    @Test
    void join() {

        //given
        JoinForm joinForm = new JoinForm();
        joinForm.setName("jeanoza");
        joinForm.setEmail("jeanoza@gmail.com");
        joinForm.setPassword("1234");

        //when
        Long savedId = authService.join(joinForm);

        //then
        memberRepository.findByEmail(joinForm.getEmail())
                .ifPresent(member -> {
                    assertEquals(savedId, member.getId());
                });
    }

    @Test
    void joinException() {

        //given
        JoinForm joinForm = new JoinForm();
        joinForm.setName("jeanoza");
        joinForm.setEmail("jeanoza@gmail.com");
        joinForm.setPassword("1234");

        JoinForm joinForm2 = new JoinForm();
        joinForm2.setName("simon");
        joinForm2.setEmail("jeanoza@gmail.com");
        joinForm2.setPassword("1234");

        //when
        authService.join(joinForm);

        //then
        assertThrows(RuntimeException.class, () -> {
            authService.join(joinForm2);
        });
    }

    @Test
    void login() {

        //given
        JoinForm joinForm = new JoinForm();
        joinForm.setName("jeanoza");
        joinForm.setEmail("jeanoza@gmail.com");
        joinForm.setPassword("1234");

        authService.join(joinForm);

        LoginForm loginForm = new LoginForm();
        loginForm.setEmail("jeanoza@gmail.com");
        loginForm.setPassword("1234");

        //when
        authService.login(loginForm);

        //then
    }

    @Test
    void loginFailed() {
        //given
        JoinForm joinForm = new JoinForm();
        joinForm.setName("jeanoza");
        joinForm.setEmail("jeanoza@gmail.com");
        joinForm.setPassword("1234");

        authService.join(joinForm);

        LoginForm loginForm = new LoginForm();
        loginForm.setEmail("jeanoza@gmail.com");
        loginForm.setPassword("1235");

        //when

        //then
        assertThrows(RuntimeException.class, () -> {
            authService.login(loginForm);
        });
    }

    @Test
    void logout() {
    }
}
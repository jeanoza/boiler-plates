package jeanoza.backendspring.service;

import jeanoza.backendspring.model.member.JoinFormDto;
import jeanoza.backendspring.model.member.LoginFormDto;
import jeanoza.backendspring.model.Member;
import jeanoza.backendspring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AuthServiceTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    AuthService authService;

    @Test
    void join() {

        //given
        JoinFormDto joinFormDto = new JoinFormDto();
        joinFormDto.setName("jeanoza");
        joinFormDto.setEmail("jeanoza@gmail.com");
        joinFormDto.setPassword("1234");

        //when
        Member savedMember = authService.join(joinFormDto);

        //then
        memberRepository.findByEmail(joinFormDto.getEmail())
                .ifPresent(member -> {
                    assertEquals(savedMember.getId(), member.getId());
                });
    }

    @Test
    void joinException() {

        //given
        JoinFormDto joinFormDto = new JoinFormDto();
        joinFormDto.setName("jeanoza");
        joinFormDto.setEmail("jeanoza@gmail.com");
        joinFormDto.setPassword("1234");

        JoinFormDto joinFormDto2 = new JoinFormDto();
        joinFormDto2.setName("simon");
        joinFormDto2.setEmail("jeanoza@gmail.com");
        joinFormDto2.setPassword("1234");

        //when
        authService.join(joinFormDto);

        //then
        assertThrows(RuntimeException.class, () -> {
            authService.join(joinFormDto2);
        });
    }

    @Test
    void login() {

        //given
        JoinFormDto joinFormDto = new JoinFormDto();
        joinFormDto.setName("jeanoza");
        joinFormDto.setEmail("jeanoza@gmail.com");
        joinFormDto.setPassword("1234");

        authService.join(joinFormDto);

        LoginFormDto loginFormDto = new LoginFormDto();
        loginFormDto.setEmail("jeanoza@gmail.com");
        loginFormDto.setPassword("1234");

        //when
        authService.login(loginFormDto);

        //then
    }

    @Test
    void loginFailed() {
        //given
        JoinFormDto joinFormDto = new JoinFormDto();
        joinFormDto.setName("jeanoza");
        joinFormDto.setEmail("jeanoza@gmail.com");
        joinFormDto.setPassword("1234");

        authService.join(joinFormDto);

        LoginFormDto loginFormDto = new LoginFormDto();
        loginFormDto.setEmail("jeanoza@gmail.com");
        loginFormDto.setPassword("1235");

        //when

        //then
        assertThrows(RuntimeException.class, () -> {
            authService.login(loginFormDto);
        });
    }

    @Test
    void logout() {
    }
}
package jeanoza.backendspring.service;

import jeanoza.backendspring.CookieUtils;
import jeanoza.backendspring.model.member.JoinFormDto;
import jeanoza.backendspring.model.Member;
import jeanoza.backendspring.model.member.LoginFormDto;
import jeanoza.backendspring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;


    //TODO: password encoding
    @Transactional
    public Member join(JoinFormDto joinFormDto) {
        if (memberRepository.findByEmail(joinFormDto.getEmail()).isPresent()) {
            throw new RuntimeException("Already registered email");
        }

        Member member = new Member();
        member.setName(joinFormDto.getName());
        member.setEmail(joinFormDto.getEmail());
        member.setPassword(joinFormDto.getPassword());

        return memberRepository.save(member);
    }

    public Member login(LoginFormDto loginFormDto) {
        if (!validationLogin(loginFormDto.getEmail(), loginFormDto.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }
        return memberRepository.findByEmail(loginFormDto.getEmail()).get();
    }

    public Member getMember(Long id) {
        return memberRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Member not found")
                );
    }

    //TODO: login logic (jwt?)
    public boolean validationLogin(String email, String password) {
        return memberRepository.findByEmail(email).isPresent() && memberRepository.findByPassword(password).isPresent();
    }
}

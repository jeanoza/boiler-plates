package jeanoza.backendspring.service;

import jeanoza.backendspring.model.JoinForm;
import jeanoza.backendspring.model.Member;
import jeanoza.backendspring.model.LoginForm;
import jeanoza.backendspring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final MemberRepository memberRepository;


    //TODO: password encoding
    @Override
    @Transactional
    public Long join(JoinForm joinForm) {
        if (memberRepository.findByEmail(joinForm.getEmail()).isPresent()) {
            throw new RuntimeException("Already registered email");
        }

        Member member = new Member();
        member.setName(joinForm.getName());
        member.setEmail(joinForm.getEmail());
        member.setPassword(joinForm.getPassword());

        return memberRepository.save(member).getId();
    }

    @Override
    public void login(LoginForm loginForm) {
        if (!validationLogin(loginForm.getEmail(), loginForm.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }
        //TODO: login logic (jwt?)
    }

    @Override
    public void logout() {
        //TODO
    }

    public boolean validationLogin(String email, String password) {
        return memberRepository.findByEmail(email).isPresent() && memberRepository.findByPassword(password).isPresent();
    }
}

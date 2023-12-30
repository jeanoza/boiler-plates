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

        Member newMember = memberRepository.save(member);
        return newMember.getId();
    }

    @Override
    public void login(LoginForm loginForm) {

    }

    @Override
    public void logout() {
        //TODO
    }
}

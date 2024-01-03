package jeanoza.backendspring.repository;

import jakarta.persistence.EntityManager;
import jeanoza.backendspring.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {
    private final EntityManager em;

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public List<Member> findAll() {
        String jpql = "select m from Member m";
        return em.createQuery(jpql, Member.class)
                .getResultList();
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        String jpql = "select m from Member m where m.email = :email";
        return em.createQuery(jpql, Member.class )
                .setParameter("email",email)
                .getResultList()
                .stream()
                .findAny();
    }

    @Override
    public Optional<Member> findByPassword(String password) {
        String jpql = "select m from Member m where m.password = :password";
        return em.createQuery(jpql, Member.class)
                .setParameter("password", password)
                .getResultList()
                .stream()
                .findAny();
    }
}

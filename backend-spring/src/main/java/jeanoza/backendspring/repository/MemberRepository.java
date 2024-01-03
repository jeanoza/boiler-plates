package jeanoza.backendspring.repository;

import jeanoza.backendspring.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    List<Member> findAll();
    Optional<Member> findById(Long id);

    Optional<Member> findByEmail(String email);

    //TODO: to remove after implement encoding system(Bcrypt?)
    Optional<Member> findByPassword(String password);
}

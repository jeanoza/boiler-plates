package jeanoza.backendspring.repository;

import jeanoza.backendspring.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

    //TODO: to remove after implement encoding system(Bcrypt?)
    Optional<Member> findByPassword(String password);
}
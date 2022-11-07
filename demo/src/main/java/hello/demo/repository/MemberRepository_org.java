package hello.demo.repository;

import hello.demo.domain.Member;

import java.util.List;
import java.util.Optional;
//회원객체를 저장하고 조회가히 위한 기능 구현

public interface MemberRepository_org {

    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();

}

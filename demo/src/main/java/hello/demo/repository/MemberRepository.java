package hello.demo.repository;

import hello.demo.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository { //메소드를 3개 기능만 정의. 내용은없음

    Member save(Member member);

    Optional<Member> findById(Long id);


    List<Member> findAll();

    Long remove(Long id); //반환값 데이터타입 확인 필요

    void clearmap();
}

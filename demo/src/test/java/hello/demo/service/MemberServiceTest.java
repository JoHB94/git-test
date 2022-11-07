package hello.demo.service;

import hello.demo.domain.Member;
import hello.demo.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemoryMemberRepository repository;
    MemberService service;

    @BeforeEach
    void beforeEach() {
        repository = new MemoryMemberRepository();
        service = new MemberService();
    }

    @AfterEach
    void tearDown() {
        service.clearRep();
    }

    @Test
    void memberJoin() {
        //given
        Member member = new Member();
        member.setName("hello1");
        //when
        Long id = service.memberJoin(member);//회원가입
        Member result = repository.findById(id).get();
        //then
        System.out.println(result.getName());
        assertThat(member.getName()).isEqualTo(result.getName());
       // = assertThat(id).isEqualTo(result.getName());


    }

    @Test
    void findAllMembers() {
        //given -- 데이터가 주어지면
        Member member = new Member();
        member.setName("hello1");
        service.memberJoin(member);

        Member member1 = new Member();
        member.setName("hello2");
        service.memberJoin(member1);
        //when
        List<Member> results = service.findAllMembers();

        //then
        assertThat(results.size()).isEqualTo(2);

    }
}
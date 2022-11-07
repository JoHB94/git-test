package hello.spring2.hello2.service;

import hello.spring2.hello2.domain.Member;
import hello.spring2.hello2.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberserviceTest {

    Memberservice memberservice;
    MemoryMemberRepository memberRepository;
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberservice = new Memberservice(memberRepository);
    }

    @Test
    void memberJoin() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId = memberservice.join(member);
        //then
        Member findMember = memberservice.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void dupMemberEcc() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberservice.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberservice.join(member2));

        /*try {
            memberservice.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
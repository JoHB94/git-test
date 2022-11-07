package hello.spring2.hello2.service;

import hello.spring2.hello2.domain.Member;
import hello.spring2.hello2.repository.MemberRepository;
import hello.spring2.hello2.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Memberservice {
    private final MemberRepository memberRepository;

    @Autowired
    public Memberservice(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {

        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByname(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member>findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}

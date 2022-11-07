package hello.demo.service;

import hello.demo.domain.Member;
import hello.demo.repository.MemberRepository;
import hello.demo.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 데이터를 저장하고 변경할 때는 항상 서비스 쪽에 @Transactional 애너테이션이 있어야 한다.
// 스프링은 해당 클래스의 메서드를 실행할 때 트랜잭션을 시작한다.
// 메서드가 정상 종료되면 트랜잭션을 커밋하고 런타임 예외가 발생하면 롤백한다.
// JPA를 통한 모든 데이터 변경은 트랜잭션 안에서 실행해야 한다.
@Transactional
@Service
public class MemberService {
    private final MemberRepository repository;
    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    /*
     *회원가입
     */

    public Long memberJoin(Member member) {
        return repository.save(member).getId();//DB를 대신할 메모리에 member를 인자로갖는 save에 getId 반환
    }
    
    /*
    *전체회원 조회
     */
    public List<Member> findAllMembers(){
        return repository.findAll();
    }

    public  Long removeMember(Member member) {
        return repository.remove(member.getId());
    }

    public void clearRep(){
        repository.clearmap();
    }
}

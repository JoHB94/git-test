package hello.demo.repository;

import hello.demo.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    /*
    * 테스트는 각각 의존관계가 없이 실행되도록 해야한다*/
    @BeforeEach
    public  void map_Initialize() {
        repository.clearmap();
    }

    @Test
    public void memberInfoSave() { //회원정보 저장 메소드를 테스트해보기 위함
        Member member1 = new Member();
        member1.setName("hello");
        repository.save(member1);
        //when 데이터를 가져왔을 때
        Member result = repository.findById(member1.getId()).get();
        //1.출력
        //2.jupiter > Assertation
        //org.jupiter.api.Assertions.asserEquals(member1,result);
        //3.Assertions > assertj> assertThat isEqualTo(member1) 이후 static import하기 :권장
        assertThat(member1).isEqualTo(result);
    }
    @Test
    public void allMembers() { //모든 회원 조회를 위한 메소드를 테스트해보기 위함
        Member member1 = new Member();
        member1.setName("hello1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("hello2");
        repository.save(member2);

        List<Member> results = repository.findAll();

        assertThat(results.size()).isEqualTo(2);


    }


}

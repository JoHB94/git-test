package hello.demo.repository;

import hello.demo.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//  MemberRepository 인터페이스 구현
//@Repository
public class MemoryMemberRepository implements MemberRepository {
    // hashmap<K.V> collection framework 사용예정

    private static Map<Long, Member> map = new HashMap<>();
    private static long sequence = 0L;// 0으로 초기화


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        map.put(sequence, member);

        return member ;
    }
    //매개변수로 들어온 id와 일치하는 값을 map에서 찾아서 이를 리턴한다.
    @Override
    public Optional<Member> findById(Long id) {
        map.get(id);
        return Optional.ofNullable(map.get(id));
    }


    @Override
    public List<Member> findAll() {
        // 현재  hashmap에 들어있는 전체 value들을 다 가져와서  arraylist의 초기값으로 넣고 이를 리턴한다.
        return new ArrayList<>(map.values());
    }

    @Override
    public Long remove(Long id) {
        return null;
    }

    /*
    *진행중 현재 map에 있는요소들을
    */

    public void clearmap() {
        map.clear();
    }
}

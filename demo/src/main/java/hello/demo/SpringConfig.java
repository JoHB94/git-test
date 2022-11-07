/*package hello.demo;

import hello.demo.repository.JdbcTemplateRep;
import hello.demo.repository.MemberRepository;
import hello.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig { // > 컨테이너가 조립할 부품목록
    // 스프링이 properties에서 설정한 대로 DataSource를 빈으로 만들어준다.
    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcTemplateRep(dataSource);
        // 사용할 빈을 주입한다.
        //return new MemoryMemberRepository();
        //@Bean이라고 등록된 클래스를 자동연결해야하는 부품이라고 스프링 컨테이너에게 알려줌
        //스프링 컨테이너: @Autowired > @Bean에 등록된 클래스중에 자동연결 할 것이 있는지 찾아서 연결해줌.

    }
}*/

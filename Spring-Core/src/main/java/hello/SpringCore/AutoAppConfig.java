package hello.SpringCore;

import hello.SpringCore.member.MemberRepository;
import hello.SpringCore.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //Spring Bean에 등록되는걸 막는거임.
)
public class AutoAppConfig {

//    @Bean(name = "memoryMemberRepository") //일부러 이름이 같게 Bean에 등록
//    //자동 빈과 수동 빈이 동시에 있을 때는 수동 빈이 자동 빈을 오버라이드 한다. -> 근데 최근 스프링 부트는 충돌시 오류가 나도록 바뀌었다.
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}

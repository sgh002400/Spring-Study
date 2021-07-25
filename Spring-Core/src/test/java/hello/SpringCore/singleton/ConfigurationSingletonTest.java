package hello.SpringCore.singleton;

import hello.SpringCore.AppConfig;
import hello.SpringCore.member.MemberRepository;
import hello.SpringCore.member.MemberServiceImpl;
import hello.SpringCore.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberRepository = " + memberRepository);
        System.out.println("memberService -> memberRepository1 = " + memberRepository1);
        System.out.println("memberService -> memberRepository2 = " + memberRepository2);

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);

        //세 개의 Spring Bean이 같은 것을 알 수 있다.
        //결론 : @Bean이 붙은 메서드마다 이미 스프링 빈이 존재하면 존재하는 빈을 반환하고, 스프링 빈이 없으면 생성해서 스프링 빈으로 등록 후 반환. -> 싱글톤 보장!
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class); //이렇게 AppConfig를 인자로 넘기면 얘도 Spring Bean으로 등록이 된다.
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
        //출력 결과 = AppConfig$$EnhancerBySpringCGLIB$$7ddb5116
        //CGLIB 라이브러리가 내부적으로 작동해서 새로운 클래스를 Spring Bean에 등록함. 그리고 얘가 알아서 싱글톤 보장해줌.
    }
}

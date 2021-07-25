package hello.SpringCore;

import hello.SpringCore.discount.DiscountPolicy;
import hello.SpringCore.discount.RateDiscountPolicy;
import hello.SpringCore.member.MemberRepository;
import hello.SpringCore.member.MemberService;
import hello.SpringCore.member.MemberServiceImpl;
import hello.SpringCore.member.MemoryMemberRepository;
import hello.SpringCore.order.OrderService;
import hello.SpringCore.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //이걸 빼고 실행하면 CGLIB가 사용되지 않는다. 그리고 싱글톤 패턴이 깨지게 된다! -> 설정 정보는 항상 Configuration을 사용하자!
public class AppConfig {

    //memberService가 호출되면 memberRepository가 호출되면서 MemoryMemberRepository 객체가 하나 생성되고,
    //orderService가 호출되면 마찬가지로 MemoryMemberRepository 객체가 또 생성되는 것처럼 보인다.
    //그럼 싱글톤 패턴이 깨지는게 아닐까?? -> Test 해보자! -> 테스트 결과는 모두 같은 인스턴스가 공유되어 사용된다.

    @Bean
    public MemberService memberService() {

        System.out.println("Call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {

        System.out.println("Call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {

        System.out.println("Call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}

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

@Configuration
public class AppConfig {

    @Bean //.getInstance() 해서 싱글톤 패턴 적용하지 않아도 Spring Container를 사용하면 기본적으로 객체를 싱글톤으로 만들어서 관리해줌
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }


    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}

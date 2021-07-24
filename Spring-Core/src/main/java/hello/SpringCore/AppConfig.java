package hello.SpringCore;

import hello.SpringCore.discount.FixedDiscountPolicy;
import hello.SpringCore.member.MemberService;
import hello.SpringCore.member.MemberServiceImpl;
import hello.SpringCore.member.MemoryMemberRepository;
import hello.SpringCore.order.OrderService;
import hello.SpringCore.order.OrderServiceImpl;

//어떤 구현 객체을 주입할지는 결정하는 클래스
public class AppConfig {

    public MemberService memberService() {
        //MemberServiceImpl에서 직접 구현체를 넣어주는게 아니라 여기서 인자로 넣어줘서 생성자를 통해 주입해줌. (생성자 주입)
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixedDiscountPolicy());
    }

}

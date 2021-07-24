package hello.SpringCore;

import hello.SpringCore.member.Grade;
import hello.SpringCore.member.Member;
import hello.SpringCore.member.MemberService;
import hello.SpringCore.member.MemberServiceImpl;
import hello.SpringCore.order.Order;
import hello.SpringCore.order.OrderService;
import hello.SpringCore.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order = " + order);    }
}

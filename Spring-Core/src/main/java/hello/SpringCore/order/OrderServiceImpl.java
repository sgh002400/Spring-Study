package hello.SpringCore.order;

import hello.SpringCore.discount.DiscountPolicy;
import hello.SpringCore.discount.FixedDiscountPolicy;
import hello.SpringCore.discount.RateDiscountPolicy;
import hello.SpringCore.member.Member;
import hello.SpringCore.member.MemberRepository;
import hello.SpringCore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{


    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //할인 정책을 변경하면 위와 같이 OrderServiceImpl의 코드를 변경해야 하므로 OCP, DIP 위반!

    /** 그렇다면 어떻게? -> 인터페이스에만 의존하도록 의존관계를 변경하여 외부로부터 구현 객체를 주입 받으면 된다. **/
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

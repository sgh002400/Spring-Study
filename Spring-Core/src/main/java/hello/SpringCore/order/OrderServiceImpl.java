package hello.SpringCore.order;

import hello.SpringCore.discount.DiscountPolicy;
import hello.SpringCore.discount.FixedDiscountPolicy;
import hello.SpringCore.discount.RateDiscountPolicy;
import hello.SpringCore.member.Member;
import hello.SpringCore.member.MemberRepository;
import hello.SpringCore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //할인 정책을 변경하면 위와 같이 OrderServiceImpl의 코드를 변경해야 하므로 OCP, DIP 위반!


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

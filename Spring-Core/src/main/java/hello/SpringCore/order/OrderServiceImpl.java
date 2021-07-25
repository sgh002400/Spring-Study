package hello.SpringCore.order;

import hello.SpringCore.discount.DiscountPolicy;
import hello.SpringCore.discount.FixedDiscountPolicy;
import hello.SpringCore.discount.RateDiscountPolicy;
import hello.SpringCore.member.Member;
import hello.SpringCore.member.MemberRepository;
import hello.SpringCore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

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

    //테스트 용도임
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

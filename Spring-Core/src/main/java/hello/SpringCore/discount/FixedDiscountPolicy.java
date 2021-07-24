package hello.SpringCore.discount;

import hello.SpringCore.member.Grade;
import hello.SpringCore.member.Member;

public class FixedDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; //1000원 고정 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}

package hello.SpringCore.discount;

import hello.SpringCore.annotation.MainDiscountPolicy;
import hello.SpringCore.member.Grade;
import hello.SpringCore.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy //@Qulifier("mainDiscountPolicy") -> 이렇게 사용해도 되긴 하지만 오타가 났을 경우 컴파일 에러를 내지 않기 때문에 잡기 힘든 에러가 날 수 있다.)
//위의 방식대로 해도 되고 @Primary 어노테이션을 사용하여 여러 빈이 매칭되었을 때 우선권을 가지게 해도 된다. -> 각각의 장단점이 있다.
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}

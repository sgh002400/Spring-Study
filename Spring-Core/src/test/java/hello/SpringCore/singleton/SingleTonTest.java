package hello.SpringCore.singleton;

import hello.SpringCore.AppConfig;
import hello.SpringCore.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingleTonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {

        AppConfig appConfig = new AppConfig();

        //기존에 만들었던 패턴은 클라이언트가 요청할 때마다 새로운 객체를 생성하는 문제가 있다.
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);

        System.out.println("memberService2 = " + memberService2);
        //memberService1 != memberService2임을 확인할 수 있다.

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

        //이런 식으로 하면 메모리 낭비가 심하다.
    }
}

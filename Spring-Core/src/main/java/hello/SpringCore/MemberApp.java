package hello.SpringCore;

import hello.SpringCore.member.Grade;
import hello.SpringCore.member.Member;
import hello.SpringCore.member.MemberService;
import hello.SpringCore.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //ApplicationContext가 스프링 컨테이너라고 보면 된다. 모든 Bean들을 관리해준다.
        //ApplicationContext는 Interface이고 AnnotationConfigApplicationContext 이게 구현체이다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); //AppConfig에 있는 메서드 이름을 name 파라미터에 넣어주면 된다.

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}

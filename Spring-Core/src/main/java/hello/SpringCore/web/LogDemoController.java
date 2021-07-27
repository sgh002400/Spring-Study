package hello.SpringCore.web;

import hello.SpringCore.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger; //스프링 컨테이너에 "myLogger"라는 이름으로 진짜 대신에 이 가짜 프록시 객체를 등록한다.
    //싱글톤처럼 보이지만 내부적으로는 요청마다 다른 객체가 생성되기 때문에 주의해서 사용해야 된다.

    @RequestMapping("log-demo")
    @ResponseBody //문자를 그대로 응답 보낼 수 있게 해줌.
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();

        System.out.println("myLogger = " + myLogger.getClass()); //출력 결과를 보면 Spring이 조작한 애가 Spring Bean으로 등록된 것을 확인할 수 있다.
        myLogger.setRequestURL(requestURL); //그리고 이 때 진짜를 찾아서 동작한다.

        myLogger.log("controller test");
        logDemoService.logic("testId");

        //가짜 프록시 객체는 내부에 진짜 myLogger를 찾는 방법을 알고 있다.
        //클라이언트가 myLogger.logic() 을 호출하면 사실은 가짜 프록시 객체의 메서드를 호출한 것이다
        //가짜 프록시 객체는 request 스코프의 진짜 myLogger.logic() 를 호출한다.

        return "OK";
    }
}

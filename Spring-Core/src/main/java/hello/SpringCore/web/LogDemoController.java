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
    private final ObjectProvider<MyLogger> myLoggerProvider; //MyLogger를 주입 받는게 아니라 이걸 찾을 수 있는 애(DL)가 주입된다.

    @RequestMapping("log-demo")
    @ResponseBody //문자를 그대로 응답 보낼 수 있게 해줌.
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();

        MyLogger myLogger = myLoggerProvider.getObject(); //진짜 필요한 이 시점에 주입을 받아 준다!(객체가 만들어진다.)
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");

        return "OK";
    }
}

package hello.SpringCore.web;

import hello.SpringCore.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;//지금 실행시키면 오류가 난다! -> 스프링 컨테이너가 뜨는 시점에는 Http 요청이 없는데 요청을 했기 때문이다!
    // -> @Provider로 해결 가능 (인터셉터를 모른다 가정한 예시임.)

    @RequestMapping("log-demo")
    @ResponseBody //문자를 그대로 응답 보낼 수 있게 해줌.
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");

        return "OK";
    }
}

package hello.SpringCore.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request") //이 빈은 HTTP 요청 당 하나씩 생성되고 HTTP 요청이 끝나는 시점에 소멸된다.

public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) { //빈이 생성되는 시점에는 requestURL을 모르므로 외부에서 입력 받음.
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "]" + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] requset scope bean created: " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] requset scope bean closed: " + this);
    }
}

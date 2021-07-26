package hello.SpringCore.lifecycle;

import org.springframework.beans.factory.InitializingBean;

public class NetworkClient {
    private String url;
    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메시지");
    }
    public void setUrl(String url) {
        this.url = url;
    }
    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }
    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }
    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    /*
    생성자 호출, url = null
    connect: null
    call: null message = 초기화 연결 메시지

    생성자 부분을 보면 url 정보 없이 connect가 호출되는 것을 확인할 수 있다.
    객체를 생성하는 단계에는 url이 없고, 객체를 생성한 다음에 외부에서 수정자 주
    입을 통해서 setUrl() 이 호출되어야 url이 존재하게 된다.
     */

}

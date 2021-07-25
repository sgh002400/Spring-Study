package hello.SpringCore.singleton;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonService {//Test Code가 아닌 SingleTon Practice

    private static final SingletonService instance = new SingletonService(); //자기 자신을 내부에 static final로 선언해서 올려줌

    public static SingletonService getInstance() { //위의 객체 인스턴스가 필요하면 이 메서드를 통해서만 조회 가능. 이 메서드 호출시 항상 같은 인스턴스 반환
        return instance;
    }

    private SingletonService() { //혹시라도 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 막기 위해 생성자를 private로 막아준다.
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}

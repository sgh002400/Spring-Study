package hello.SpringCore.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {
    @Test
    public void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        //출력 결과를 보면 find prototypeBean1이 호출된 이후에 init 메서드가 호출됨을 알 수 있다.

        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);

        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);


        ac.close(); //close를 호출해도 @PreDestroy 같은 종료 메서드가 실행되지 않음을 확인할 수 있다.

        //만약 종료하고 싶다면
        //prototypeBean1.destroy(); 이런식으로 직접 호출해야 된다.
    }

    @Scope("prototype")
    //@Component를 붙이지 않아도 위에서 AnnotationConfigApplicationContext 인자로 넣으면 알아서 Component로 등록해줌
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}

package hello.SpringCore;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( //@Component annotation이 붙은 class를 찾아서 알아서 Spring Bean으로 등록해준다.
        basePackages = "hello.SpringCore", //탐색할 패키지의 시작 위치를 지정한다. 이 패키지를 포함해서 하위 패키지 모두를 탐색한다.
        //만약 이걸 붙이지 않는다면? -> 해당 파일(AutoAppConfig)이 있는 위치부터 하위 패키지 모두를 탐색함
        //패키지 위치를 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상 단에 두는 것이 권장

        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //Spring Bean에 등록되는걸 막는거임.
        //@Configuration이 붙은 파일(AppConfig)에서는 Bean을 수동으로 등록하는데 여기서 자동으로 또 등록하면 충돌이 일어나기 때문에 제외함.
)
public class AutoAppConfig {
    //AutoAppConfig는 로직이 아무것도 없는데 어떻게 의존관계 주입할거야?? -> @Autowired 사용!
}

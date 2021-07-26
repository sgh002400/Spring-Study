package hello.SpringCore;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( //@Component annotation이 붙은 class를 찾아서 알아서 Spring Bean으로 등록해준다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //Spring Bean에 등록되는걸 막는거임.
        //@Configuration이 붙은 파일(AppConfig)에서는 Bean을 수동으로 등록하는데 여기서 자동으로 또 등록하면 충돌이 일어나기 때문에 제외함.
)
public class AutoAppConfig {
    //AutoAppConfig는 로직이 아무것도 없는데 어떻게 의존관계 주입할거야?? -> @Autowired 사용!
}

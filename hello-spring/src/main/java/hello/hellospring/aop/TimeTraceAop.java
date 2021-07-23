package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component //이렇게 해도 되고 Spring Bean에 등록해서 써도 되는데 직접 등록을 선호함
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))") //어디에 적용할지 타겟팅 해주는거임.-> 여기서는 전체에 적용한거
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed(); //다음 메서드로 진행되게 해줌
            //조건을 걸어서 ~ 조건일 땐 넘어가지 못하게 할 수도 있음.
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}

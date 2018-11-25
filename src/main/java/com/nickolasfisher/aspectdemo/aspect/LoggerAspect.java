package com.nickolasfisher.aspectdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class LoggerAspect {

    @Around("execution(public * *(..)) && within(com.nickolasfisher.aspectdemo..*)")
    private Object logAroundEveryPublicMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("\n-----------beginning around advice---------");

        System.out.println("arguments: " + Arrays.stream(pjp.getArgs()).map(Object::toString).collect(Collectors.toList()));
        System.out.println("pointcut as long string: " + pjp.toLongString());
        System.out.println("method signature: " + pjp.getSignature());
        System.out.println("target class: " + pjp.getTarget().toString());
        System.out.println("class in use: " + pjp.getSourceLocation().getWithinType());

        Object returnedVal = pjp.proceed();

        System.out.println("returned value: " + returnedVal);
        System.out.println("---------around advice concluded---------\n");
        return returnedVal;
    }
}

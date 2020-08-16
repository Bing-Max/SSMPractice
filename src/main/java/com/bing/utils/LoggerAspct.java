package com.bing.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspct {

    @Around(value = "execution(* com.bing.dao.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("start log:" + joinPoint.getSignature().getName());
        Object object = joinPoint.proceed();
        System.out.println("end log:" + joinPoint.getSignature().getName());
        return object;
    }

    @Around(value = "execution(* com.bing.utils.MapDataUtils.getData())")
    public Object logNet(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("start net access: " + joinPoint.getSignature().getName());
        Object object = joinPoint.proceed();
        System.out.println("end net access:" + joinPoint.getSignature().getName());
        return object;
    }

}

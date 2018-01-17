package com.dongchen.java.springboot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

/**
 * @author: mdd
 * @date:2018/1/1
 * @描述:
 */
@Aspect
@Order(0)
@Configuration
public class TestAspect2 {

    @Around("execution(* com.mdd.java.service.*.*(..))")
    public Object testAspect(final ProceedingJoinPoint joinPoint) throws Throwable{
        try{
            Object[] args = joinPoint.getArgs();
            System.out.println("args:" + Arrays.asList(args));

            Object o = joinPoint.proceed();
            System.out.println("return :" + o);
            return o;
        }catch (Throwable e){
            throw  e;
        }
    }

    @Around("@within(org.springframework.stereotype.Service)")
    public Object testAspect2(final ProceedingJoinPoint joinPoint) throws Throwable{
        try{
            Object[] args = joinPoint.getArgs();
            System.out.println("args2:" + Arrays.asList(args));

            Object o = joinPoint.proceed();
            System.out.println("return2 :" + o);
            return o;
        }catch (Throwable e){
            throw  e;
        }
    }

}

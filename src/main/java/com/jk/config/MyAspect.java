package com.jk.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class MyAspect {
    // execution 方法级别的切入点表达式
    // within 类级别的切入点表达式
    @Pointcut("execution(* com.jk.service..*.*(..))")
    private void pointCut(){}


    @Pointcut("within(com.jk.service..*)")
    private void point(){}

//    @Before("pointCut()") // 前置附加操作
//    public void  before(JoinPoint joinPoint){
//        System.out.println("=======前置========");
//        System.out.println("执行点：----》"+joinPoint.getTarget());
//    }
//
    @After("@annotation(com.jk.annotations.myAdvice)") // 前置附加操作
    public void  after(JoinPoint joinPoint){
        System.out.println("=======后置========");
        System.out.println("执行点：----》"+joinPoint.getTarget());
    }

//    @Around("point()")
//    // ProceedingJoinPoint 处理过程中的连接点
//    public Object around(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("=======around前置========");
//        System.out.println("=======around前置========"+pjp.getTarget()+"=========="+pjp.getSignature().getName());
//        Object res = pjp.proceed(); //放行结果
//        return  res;
//    }

    // 使用annotation注解进行切面操作(推荐此种方案)
    @Around("@annotation(com.jk.annotations.myAdvice)")
    // ProceedingJoinPoint 处理过程中的连接点
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("=======around前置========");
        System.out.println("=======around前置========"+pjp.getTarget()+"=========="+pjp.getSignature().getName());
        Object res = pjp.proceed(); //放行结果
        return  res;
    }
}

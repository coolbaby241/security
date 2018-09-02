package com.code.web.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * com.code.web.aspect
 *
 * @Auther: shenc
 * @Date: 2018/9/2 12:03
 * @Description:
 */
//@Aspect
//@Component
public class TimeAspect {

    @Around("execution(* com.code.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("time aspect start");
        //请求参数
        Object[] objects = pjp.getArgs();
        for (Object object:objects){
            System.out.println("arg is " + object);
        }
        long  start = new Date().getTime();
        Object object = pjp.proceed();
        System.out.println("time aspect 耗时:"+ (new Date().getTime() - start));
        System.out.println("time aspect end");
        return object;
    }

}

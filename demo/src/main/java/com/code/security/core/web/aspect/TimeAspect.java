package com.code.security.core.web.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

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

    @Around("execution(* UserController.*(..))")
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

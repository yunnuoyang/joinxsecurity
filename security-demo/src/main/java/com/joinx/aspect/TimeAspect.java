package com.joinx.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
   @Around(value = "execution(* com.joinx.controller.UserController.*(..))")
   public Object around(ProceedingJoinPoint point) throws Throwable {
      System.out.println("TimeAspect is start");
      Object[] args = point.getArgs();
      //被拦截的方法
      Object proceed = point.proceed();
      System.out.println(point+"===");
      return proceed;
   }
}

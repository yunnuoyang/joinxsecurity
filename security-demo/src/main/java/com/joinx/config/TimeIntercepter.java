package com.joinx.config;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
//@Component
public class TimeIntercepter implements HandlerInterceptor {
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      System.out.println("preHandle is start");
//      System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
//      System.out.println(((HandlerMethod)handler).getMethod().getName());
      request.setAttribute("startTime",new Date().getTime());
      return true;
   }
   
   @Override
   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
      System.out.println("postHandle is start");
      long startTime = (long) request.getAttribute("startTime");
      System.out.println("耗时："+(new Date().getTime()-startTime));
   
   }
   
   @Override
   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
   
   }
}

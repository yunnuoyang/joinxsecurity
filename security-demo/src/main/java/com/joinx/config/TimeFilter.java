package com.joinx.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

//@Component//使用此种方式无法指定url
public class TimeFilter implements Filter {
   @Override
   public void init(FilterConfig filterConfig) throws ServletException {
      System.out.println("time filter is init...");
   }
   
   @Override
   public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
      long start=new Date().getTime();
      System.out.println("timefilter is start...");
      filterChain.doFilter(servletRequest,servletResponse);
      System.out.println("耗费时间"+(new Date().getTime()-start));
   }
   
   @Override
   public void destroy() {
      System.out.println("timefilter is destory...");
   }
}

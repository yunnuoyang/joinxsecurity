package com.joinx.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
   @Bean
   public FilterRegistrationBean timeFilter(){
      FilterRegistrationBean bean=new FilterRegistrationBean();
      TimeFilter timeFilter=new TimeFilter();
      bean.setFilter(timeFilter);
      //设置访问的url
      List list=new ArrayList();
//      list.add("/user");
      list.add("/user/1");
      bean.setUrlPatterns(list);
      return bean;
   }
   
   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(new TimeIntercepter());
   }
}

package com.joinx.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//封装认证信息
@Component
public class JoinxAuthenticationHandler implements AuthenticationSuccessHandler ,AuthenticationFailureHandler {
  Logger logger=LoggerFactory.getLogger(getClass());
  @Autowired
  private ObjectMapper objectMapper;
   @Override
   public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
   logger.info("登陆成功！");
   response.setContentType("application/json;charset=utf-8");
   response.getWriter().print(objectMapper.writeValueAsString(authentication));
   }
   
   @Override
   public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
      logger.info("登陆失败！");
      response.setStatus(500);
      response.setContentType("application/json;charset=utf-8");
      response.getWriter().print(objectMapper.writeValueAsString(e));
   }
}

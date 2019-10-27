package com.joinx.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joinx.core.LoginType;
import com.joinx.core.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SavedAuthenticationHandler extends SavedRequestAwareAuthenticationSuccessHandler {
   Logger logger=LoggerFactory.getLogger(getClass());
   @Autowired
   private ObjectMapper objectMapper;
   @Autowired
   private SecurityProperties securityProperties;
   @Override
   public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
      logger.info("登陆成功！");
      if(LoginType.JSON.equals(securityProperties.getBrowserProperties().getLoginType())){
         response.setContentType("application/json;charset=utf-8");
         response.getWriter().print(objectMapper.writeValueAsString(authentication));
      }else{
         super.onAuthenticationSuccess(request,response,authentication);
      }
   }
}

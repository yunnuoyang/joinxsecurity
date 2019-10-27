package com.joinx.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joinx.core.SecurityProperties;
import com.joinx.pojo.SimpleResponse;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@RestController
public class BroswerController {
   //security将请求缓存到此类中
   org.slf4j.Logger logger=LoggerFactory.getLogger(getClass());
   private RequestCache requestCache=new HttpSessionRequestCache();
   private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
   @Autowired
   private SecurityProperties securityProperties;
   @RequestMapping("authentication/require")
   @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
   public SimpleResponse authenticationRequire(HttpServletRequest request, HttpServletResponse response) throws IOException {
      SavedRequest savedRequest=requestCache.getRequest(request,response);
      if(savedRequest!=null){
         //引发跳转的请求
         String targetUrl = savedRequest.getRedirectUrl();
         logger.info(targetUrl+"请求访问的url");
      if(StringUtils.endsWithIgnoreCase(targetUrl,".html")){
         redirectStrategy.sendRedirect(request,response,securityProperties.getBrowserProperties().getLoginPage());
      }
      }
      return new SimpleResponse("访问的服务需要认证，请引导用户到登录页");
   }
   @RequestMapping("/me")
   public Object getAuthenticationInfo(Authentication authentication){
      return authentication;
//      return SecurityContextHolder.getContext().getAuthentication();
   }
}

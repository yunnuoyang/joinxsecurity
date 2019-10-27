package com.joinx.social.qq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * AbstractOAuth2ApiBinding
 * accessToken 存放每个用户的token
 */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {
  private static final String URL_GET_OPENID="https://graph.qq.com/oauth2.0/me?access_token=%s";
  private static final String URL_GET_USERINFO="https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";
   private String appId;
   private String openId;
   
   private ObjectMapper objectMapper=new ObjectMapper();
   public QQImpl(String accessToken,String appId){
      //父类处理accessToken
      super(accessToken,TokenStrategy.ACCESS_TOKEN_PARAMETER);
      this.appId=appId;
      String url=String.format(URL_GET_OPENID,accessToken);
      String result=getRestTemplate().getForObject(url,String.class);
      System.out.println(result);
      this.openId= org.apache.commons.lang.StringUtils.substringBetween(result,"\"openid\":","}");
      
   }
   @Override
   public QQUserInfo getUserInfo() throws IOException {
      String url=String.format(URL_GET_USERINFO,appId,openId);
      String result=getRestTemplate().getForObject(url,String.class);
      System.out.println(result);
   
        return objectMapper.readValue(result,QQUserInfo.class);
        
   }
}

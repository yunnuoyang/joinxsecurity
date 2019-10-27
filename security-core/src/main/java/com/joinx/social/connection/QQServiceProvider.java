package com.joinx.social.connection;

import com.joinx.social.qq.QQ;
import com.joinx.social.qq.QQImpl;
import org.springframework.social.oauth1.AbstractOAuth1ServiceProvider;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Template;

public class QQServiceProvider  extends AbstractOAuth2ServiceProvider<QQ> {
   private String appId;
   private static final String URL_AUTHORIZE="https://graph.qq.com/oauth2.0/authorize";
   private static final String URL_ACCESS_TOKEN="https://graph.qq.com/oauth2.0/authorize";
   
   public QQServiceProvider(String appId,String appSecret) {
      super(new OAuth2Template(appId,appSecret,URL_AUTHORIZE,URL_ACCESS_TOKEN));
   }
   
   @Override
   public QQ getApi(String accessToken) {
      return new QQImpl(accessToken,appId);
   }
}

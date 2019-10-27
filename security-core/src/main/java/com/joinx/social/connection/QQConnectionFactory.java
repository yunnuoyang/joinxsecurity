package com.joinx.social.connection;

import com.joinx.social.qq.QQ;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {
   
   public QQConnectionFactory(String providerId,String appId,String appSecret) {
      super(providerId, new QQServiceProvider(appId,appSecret), new QQAdapter());
   }
}

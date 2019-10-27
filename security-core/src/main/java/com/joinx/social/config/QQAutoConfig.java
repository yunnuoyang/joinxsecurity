package com.joinx.social.config;

import com.joinx.core.QQProperties;
import com.joinx.core.SecurityProperties;
import com.joinx.social.connection.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.stereotype.Component;

@Configuration
//@ConditionalOnProperty(prefix = "joinx.security.social.qq",name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {
   @Autowired
   SecurityProperties securityProperties;
   @Override
   protected ConnectionFactory<?> createConnectionFactory() {
      QQProperties qqConfig=securityProperties.getSocialProperties().getQq();
      return new QQConnectionFactory(qqConfig.getProviderId(),qqConfig.getAppId(),qqConfig.getAppSecret());
   }
}

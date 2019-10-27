package com.joinx.social;

import com.joinx.social.config.QQAutoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {
   @Autowired
   private DataSource dataSource;
   @Override
   public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
      JdbcUsersConnectionRepository jdbcUsersConnectionRepository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
      //Encryptors.noOpText()加解密工具，noOpText()不做任何处理
      //JdbcUsersConnectionRepository 包中包含数据库文件
      jdbcUsersConnectionRepository.setTablePrefix("joinx_");
//      jdbcUsersConnectionRepository.setConnectionSignUp();
      return jdbcUsersConnectionRepository;
   }
   @Bean
   public SpringSocialConfigurer joinxSecuritySocialConfig(){
    return new SpringSocialConfigurer();
    
   }
}

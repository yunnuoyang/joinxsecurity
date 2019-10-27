package com.joinx.core;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "joinx.security")
public class SecurityProperties {
   private BrowserProperties browserProperties=new BrowserProperties();
   private SocialProperties socialProperties=new SocialProperties();
   
   public SocialProperties getSocialProperties() {
      return socialProperties;
   }
   
   public void setSocialProperties(SocialProperties socialProperties) {
      this.socialProperties = socialProperties;
   }
   
   public BrowserProperties getBrowserProperties() {
      return browserProperties;
   }
   
   public void setBrowserProperties(BrowserProperties browserProperties) {
      this.browserProperties = browserProperties;
   }
}

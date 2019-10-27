package com.joinx.core;

public class BrowserProperties {
   //标准的登录页
   private String loginPage="/represent-signIn.html";
   private LoginType loginType=LoginType.JSON;
   
   public LoginType getLoginType() {
      return loginType;
   }
   
   public void setLoginType(LoginType loginType) {
      this.loginType = loginType;
   }
   
   public String getLoginPage() {
      return loginPage;
   }
   
   public void setLoginPage(String loginPage) {
      this.loginPage = loginPage;
   }
}

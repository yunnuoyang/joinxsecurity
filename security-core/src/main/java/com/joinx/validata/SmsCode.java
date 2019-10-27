package com.joinx.validata;

import java.time.LocalDateTime;

public class SmsCode {
   private String code;
   private LocalDateTime expireTime;
   
   public SmsCode(String code, LocalDateTime expireTime) {
      this.code = code;
      this.expireTime = expireTime;
   }
   
   public String getCode() {
      return code;
   }
   
   public void setCode(String code) {
      this.code = code;
   }
   
   public LocalDateTime getExpireTime() {
      return expireTime;
   }
   
   public void setExpireTime(LocalDateTime expireTime) {
      this.expireTime = expireTime;
   }
}

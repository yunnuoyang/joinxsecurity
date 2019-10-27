package com.joinx.validata;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 图片验证码的信息
 */
public class ImgCode {
   private BufferedImage image;
   private String code;
   private LocalDateTime expireTime;
   
   public ImgCode(BufferedImage image, String code, LocalDateTime expireTime) {
      this.image = image;
      this.code = code;
      this.expireTime = expireTime;
   }
   public ImgCode(BufferedImage image, String code, int expireIn) {
      this.image = image;
      this.code = code;
      this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
   }
   
   public BufferedImage getImage() {
      return image;
   }
   
   public void setImage(BufferedImage image) {
      this.image = image;
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

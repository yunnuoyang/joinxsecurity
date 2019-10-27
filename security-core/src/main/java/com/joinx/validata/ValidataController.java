package com.joinx.validata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@RestController
public class ValidataController {
   private static final String SESSION_KEY="SESSION_KEY";
   private SessionStrategy strategy=new HttpSessionSessionStrategy();
   @Autowired
//   private
   /**
    * 图片验证码的服务
    * @param request
    * @param response
    * @throws IOException
    */
   @RequestMapping("/code/image")
   public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
       ImgCode imgCode=ImageUtils.createImageCode(request);
       strategy.setAttribute(new ServletWebRequest(request),SESSION_KEY,imgCode);
      ImageIO.write(imgCode.getImage(),"JPEG",response.getOutputStream());
   }
   
   /**
    * 发送短信验证码的服务
    * @param request
    * @param response
    * @throws IOException
    */
   @RequestMapping("/code/sms")
   public void createSms(HttpServletRequest request, HttpServletResponse response) throws IOException {
       ImgCode imgCode=ImageUtils.createImageCode(request);
       strategy.setAttribute(new ServletWebRequest(request),SESSION_KEY,imgCode);
      ImageIO.write(imgCode.getImage(),"JPEG",response.getOutputStream());
   }
   
  
}

package com.joinx.social.connection;

import com.joinx.social.qq.QQ;
import com.joinx.social.qq.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

import java.io.IOException;

public class QQAdapter implements ApiAdapter<QQ> {
   /**
    * 默认与qq的接口一直连接
    * @param api
    * @return
    */
   @Override
   public boolean test(QQ api) {
      return true;
   }
   
   @Override
   public void setConnectionValues(QQ api, ConnectionValues values) {
      try {
         QQUserInfo userInfo=api.getUserInfo();
        values.setDisplayName(userInfo.getNickname());
        values.setImageUrl(userInfo.getFigureurl_1());
        values.setProfileUrl(null);
        values.setProviderUserId(userInfo.getOpenId());
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   @Override
   public UserProfile fetchUserProfile(QQ qq) {
      return null;
   }
   
   @Override
   public void updateStatus(QQ qq, String s) {
   
   }
}

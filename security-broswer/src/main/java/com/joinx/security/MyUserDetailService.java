package com.joinx.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailService implements UserDetailsService,SocialUserDetailsService {
   
   private PasswordEncoder passwordEncoder;
   
   /**
    * 表单登陆时使用
    * @param s
    * @return
    * @throws UsernameNotFoundException
    */
   @Override
   public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
      System.out.println(s+"====");
      MyPasswordEncoder encoder = new MyPasswordEncoder();
      return new User(s,encoder.encode("123456"),AuthorityUtils.createAuthorityList("admin","root"));
   }
   
   /**
    * 社交登陆时使用
    * @param
    * @return
    * @throws UsernameNotFoundException
    */
   @Override
   public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
      System.out.println("登陆用户名："+userId);
      return new SocialUser(userId,passwordEncoder.encode("123456"),
             true,true,true,true,
             AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
   }
}

package com.joinx.security;

import com.joinx.authentication.JoinxAuthenticationHandler;
import com.joinx.core.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

@Configuration
public class BrowsreSecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
   private SecurityProperties securityProperties;
  @Autowired
  private  JoinxAuthenticationHandler handler;
  
  @Autowired
  private SpringSocialConfigurer joinxSocialConfig;
  @Autowired
  private MyUserDetailService userDetailService;
  @Autowired
  private MyPasswordEncoder passwordEncoder;
   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.formLogin()
             //自定义登录页
             .loginPage("/authentication/require")
             ///      UsernamePasswordAuthenticationFilter
             .loginProcessingUrl("/authtication/form")
             .successHandler(handler)
             .failureHandler(handler)
//      http.httpBasic()
             .and()
             .apply(joinxSocialConfig)
             .and()
             .authorizeRequests()
             //放行此url
             .antMatchers("/authentication/require",securityProperties.getBrowserProperties().getLoginPage()
             ,"/code/image").permitAll()
             .anyRequest()
             .authenticated();
      //关闭默认的csrf认证，防止跨站攻击：crsf
      http.csrf().disable();
   }
   
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      //可以设置内存指定的登录的账号密码,指定角色
      //不加.passwordEncoder(new MyPasswordEncoder())
      //就不是以明文的方式进行匹配，会报错
//      auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
//      //.passwordEncoder(new MyPasswordEncoder())。
//      //这样，页面提交时候，密码以明文的方式进行匹配。
//      auth.inMemoryAuthentication().passwordEncoder(
//             new MyPasswordEncoder())
//             .withUser("cxh")
//             .password("cxh").roles("ADMIN")
//               ;
      auth.userDetailsService(userDetailService
      ).passwordEncoder(passwordEncoder);
   }
   
   @Override
   public void configure(WebSecurity web) throws Exception {
      //放行静态资源
   }
}

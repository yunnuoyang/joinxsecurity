package com.joinx.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.stereotype.Component;

@Component
public class MyPasswordEncoder implements PasswordEncoder {
   @Override
   public String encode(CharSequence charSequence) {
//      UsernamePasswordAuthenticationFilter
//      UserDetailsService
//      SecurityContextPersistenceFilter
//      SecurityContextHolder
//      UserDetails
//      Authentication
//      SecurityContext
      return charSequence.toString();
   }

   @Override
   public boolean matches(CharSequence charSequence, String s) {
      return s.equals(charSequence.toString());
   }
}

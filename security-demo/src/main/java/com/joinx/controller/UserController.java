package com.joinx.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.joinx.pojo.User;
import com.joinx.valid.MyValidation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
   @JsonView(User.UserSimpleView.class)
   @RequestMapping(value = "/user",method = RequestMethod.GET)
   public List<User> user(@RequestParam() String username){
      List<User> us=new ArrayList<>();
     User u1=new User();
     u1.setName("s");
      us.add(u1);
      us.add(new User());
      return us;
   }
   @JsonView(User.UserDetailView.class)
   @RequestMapping(value = "/user/1",method = RequestMethod.GET)
   @ApiOperation(value = "查询用户的服务")
   public User user(){
     User u1=new User();
     u1.setName("s");
      u1.setSex('男');
      return u1;
   }
   @PostMapping("/user")
   public User create(@ApiParam(value = "用户参数") @Valid @RequestBody User user){
      System.out.println(user.getName());
      
      System.out.println(user.getSex());
      System.out.println(user.getDateTime());
      return user;
   }
  
}

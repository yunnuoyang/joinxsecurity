package com.joinx.pojo;

import com.fasterxml.jackson.annotation.JsonView;
import com.joinx.valid.MyValidation;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

public class User {
   public interface UserSimpleView{}
   public interface UserDetailView extends UserSimpleView{}
//   @Size(min = 6,message = "最短大于六")
//   @NotNull
   @NotBlank
   @MyValidation(message = "这是性别")
   @ApiModelProperty(value = "用户名")
   private String name;
   private Character sex;
   private Date dateTime;
   
   public Date getDateTime() {
      return dateTime;
   }
   
   public void setDateTime(Date dateTime) {
      this.dateTime = dateTime;
   }
   
   @JsonView(UserSimpleView.class)
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   /**
    * 使用jsonView可以返回不同的视图
    * @return
    */
   @JsonView(UserDetailView.class)
   public Character getSex() {
      return sex;
   }
   
   public void setSex(Character sex) {
      this.sex = sex;
   }
}

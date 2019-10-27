package com.joinx.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyValidationConstraint implements ConstraintValidator<MyValidation,String> {
   @Override
   public void initialize(MyValidation constraintAnnotation) {
      System.out.println("my validator init");
   }
   
   @Override
   public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
      System.out.println(s+"开始你的校验规则");
      return true;
   }
}

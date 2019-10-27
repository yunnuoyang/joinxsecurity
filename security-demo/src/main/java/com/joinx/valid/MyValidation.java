package com.joinx.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy =MyValidationConstraint.class )
public @interface MyValidation {
   String message() default "{javax.validation.constraints.MyValidation.message}";
   
   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default { };;
}

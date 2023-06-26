package com.anand.spring.validation.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmployeeTypeValidator.class)
public @interface ValidateEmployeeType {

    public String messge() default "Invalid Employee Type";

    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};


}

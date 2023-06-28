package com.anand.spring.validation.dto;


import com.anand.spring.validation.validators.ValidateEmployeeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    private int userId;
    @NotNull(message = "User name should not be null")
    private String name;
    @Email(message = "Invalid email entered")
    private String email;
    @Pattern(regexp="^\\d{10}$",message = "Invalid Mobile number entered")
    private String mobile;
    private String gender;
    @Min(16)
    @Max(60)
    private int age;
    @NotBlank
    private String nationality;

    @ValidateEmployeeType
    private String employeeType;

}

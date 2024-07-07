package com.salshaikhi.task.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {

    @NotNull(message = "Full name is required")
    private String fullName;

    @NotNull
    @Email(message = "Enter a valid email")
    private String email;

    @NotNull
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;
}

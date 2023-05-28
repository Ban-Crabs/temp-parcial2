package com.bancrabs.tempparcial2.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegisterDTO {
    
    @NotEmpty
    private String username;
    
    @NotEmpty
    @Email
    private String email;
    
    @NotEmpty
    @Size(min = 8)
    private String password;
}

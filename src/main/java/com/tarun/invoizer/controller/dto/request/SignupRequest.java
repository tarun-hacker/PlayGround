package com.tarun.invoizer.controller.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class SignupRequest {

    @NotBlank
    String username;

    @NotBlank
    String email;

    @NotBlank
    String password;

    @NotNull
    Set<String> role;


}

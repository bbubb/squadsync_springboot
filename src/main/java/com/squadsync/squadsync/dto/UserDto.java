package com.squadsync.squadsync.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String uuid;
    @NotBlank
    private String email;
    private String emailUpperCase;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    private String userStatus;
    private String role;
}

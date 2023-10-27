package com.squadsync.squadsync.controller;

import com.squadsync.squadsync.dto.response.GetUserResponseDto;
import com.squadsync.squadsync.dto.response.GetUserSingleResponseDto;
import com.squadsync.squadsync.service.AuthorizationService;
import com.squadsync.squadsync.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final AuthorizationService authorizationService;

    @Autowired
    public UserController(
            @NonNull final UserService userService,
            @NonNull final AuthorizationService authorizationService) {

        this.userService = userService;
        this.authorizationService = authorizationService;
    }

    @Operation(summary = "Return a list of Users.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully returned a list of Users."),
            @ApiResponse(responseCode = "401", description = "Unauthorized."),
            @ApiResponse(responseCode = "403", description = "Forbidden.")
    })
    @GetMapping
    public ResponseEntity<GetUserResponseDto> getAllUsers(
            @RequestHeader("Authorization") @NotEmpty final String authorizationHeader) {

        this.authorizationService.authorize(authorizationHeader);
        return ResponseEntity
                .ok(GetUserResponseDto
                        .builder()
                        .userDtoList(this.userService.getAllUsers())
                        .build());
    }

    @Operation(summary = "Return a User by uuid.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully returned a User by uuid."),
            @ApiResponse(responseCode = "401", description = "Unauthorized."),
            @ApiResponse(responseCode = "403", description = "Forbidden."),
            @ApiResponse(responseCode = "404", description = "User can not be found or does not exist with provided uuid.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content)
    })
    @GetMapping("/{userUuid}")
    public ResponseEntity<GetUserSingleResponseDto> getUserByUuid(
            @NotEmpty @PathVariable("userUuid") final String userUuid,
            @NotEmpty @RequestHeader("Authorization") final String authorizationHeader) {

        this.authorizationService.authorize(authorizationHeader);
        return ResponseEntity
                .ok(GetUserSingleResponseDto
                        .builder()
                        .userDto(this.userService.getUserSingleByUuid(userUuid))
                        .build());
    }

    @Operation(summary = "Return a User by email.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully returned a User by email."),
            @ApiResponse(responseCode = "401", description = "Unauthorized."),
            @ApiResponse(responseCode = "403", description = "Forbidden."),
            @ApiResponse(responseCode = "404", description = "User can not be found or does not exist with provided email.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content)
    })
    @GetMapping("/authorizationTokenEmail")
    public ResponseEntity<GetUserSingleResponseDto> getUserByAuthorizationTokenEmail(
            @NotEmpty @RequestHeader("Authorization") final String authorizationHeader) {

        String email = "changeThisToEmailFromAuthorizationToken";

        return ResponseEntity
                .ok(GetUserSingleResponseDto
                        .builder()
                        .userDto(this.userService.getUserByEmail(email))
                        .build());
    }
}

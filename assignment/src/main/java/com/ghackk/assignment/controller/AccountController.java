package com.ghackk.assignment.controller;

import com.ghackk.assignment.document.User;
import com.ghackk.assignment.dto.LoginResponse;
import com.ghackk.assignment.dto.UserDto;
import com.ghackk.assignment.service.JwtService;
import com.ghackk.assignment.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ankit Khatri
 */

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AccountController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> register(@RequestBody UserDto registerUserDto) {
        UserDto registeredUser = authenticationService.signup(registerUserDto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody UserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = LoginResponse.builder().token(jwtToken).expiresIn(jwtService.getExpirationTime()).build();
        return ResponseEntity.ok(loginResponse);
    }
}

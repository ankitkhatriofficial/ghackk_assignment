package com.ghackk.assignment.service;

import com.ghackk.assignment.converter.UserConverter;
import com.ghackk.assignment.document.User;
import com.ghackk.assignment.dto.UserDto;
import com.ghackk.assignment.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Ankit Khatri
 */
@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto signup(UserDto input) {
        User user = User.builder().firstName(input.getFirstName())
                .lastName(input.getLastName())
                .email(input.getEmail())
                .password(passwordEncoder.encode(input.getPassword())).build();
        user = this.userRepository.save(user);
        return UserConverter.entityToDto(user);
    }

    public User authenticate(UserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                ));
        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }

}

package com.angularbackend.backendangular.controller;

import com.angularbackend.backendangular.dtos.UserDTO;
import com.angularbackend.backendangular.model.User;
import com.angularbackend.backendangular.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AuthController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        if(userService.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        var userOpt = userService.findByEmail(userDTO.getEmail());

        if(userOpt.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        boolean passwordMatches = passwordEncoder.matches(
                userDTO.getPassword(),
                userOpt.get().getPassword()
        );

        var authToken = new UsernamePasswordAuthenticationToken(
                userDTO.getEmail(),
                userDTO.getPassword()
        );
        var authentication = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return ResponseEntity.ok().build();
    }
}

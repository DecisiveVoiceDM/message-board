package com.example.onlinemessageboard.controller;

import com.example.onlinemessageboard.jwt.JwtProvider;
import com.example.onlinemessageboard.dto.AuthRequest;
import com.example.onlinemessageboard.dto.AuthResponse;
import com.example.onlinemessageboard.jwt.RegistrationRequestDTO;
import com.example.onlinemessageboard.model.User;
import com.example.onlinemessageboard.service.ProfileService;
import com.example.onlinemessageboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final UserService userService;
    private final ProfileService profileService;
    private final JwtProvider jwtProvider;

    @Autowired
    public AuthController(UserService userService, ProfileService profileService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.profileService = profileService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequestDTO registrationRequestDTO) {
        User user = new User();
        user.setEmail(registrationRequestDTO.getEmail());
        user.setPassword(registrationRequestDTO.getPassword());
        user.setFirstName(registrationRequestDTO.getFirstName());
        user.setLastName(registrationRequestDTO.getLastName());
        user.setAge(registrationRequestDTO.getAge());
        userService.saveUser(user);
        profileService.saveProfile(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        User user = userService.findByEmailAndPassword(request.getEmail(), request.getPassword());
        String token = jwtProvider.generateToken(user.getEmail());
        return new AuthResponse(token);
    }
}


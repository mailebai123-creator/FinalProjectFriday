package com.example.demo.service;

import com.example.demo.config.BeksultanJwtUtil;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final BeksultanJwtUtil jwtUtil;
    public String register(RegisterRequest registerRequest){
        if(repository.findByEmail(registerRequest.getEmail()).isPresent()){
            throw new BadRequestException("Email alredy exists");
        }
        User user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(encoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();

        repository.save(user);
        return "User registered";
    }
    public AuthResponse login(LoginRequest request){
        User user = repository.findByEmail(request.getEmail())
                .orElseThrow(()->new BadRequestException("User not found"));
        if(!encoder.matches(request.getPassword(), user.getPassword())){
            throw new BadRequestException("Wrong password");
        }
        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token);
    }
}

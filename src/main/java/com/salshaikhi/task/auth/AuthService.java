package com.salshaikhi.task.auth;

import com.salshaikhi.task.config.JwtService;
import com.salshaikhi.task.dto.UserDto;
import com.salshaikhi.task.exception.NotFoundException;
import com.salshaikhi.task.model.User;
import com.salshaikhi.task.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthenticationManager authenticationManager, UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(()-> new NotFoundException("User not found"));
        String jwtToken = jwtService.generateToken(user);
        return new AuthResponse(jwtToken);
    }

    public void register(UserDto userDto) {
        userRepository.save(userMapper(userDto));
    }

    private User userMapper(UserDto user){
        User newUser = new User();
        newUser.setFullName(user.getFullName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return newUser;
    }
}

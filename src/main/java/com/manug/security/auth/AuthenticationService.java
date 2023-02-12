package com.manug.security.auth;

import com.manug.security.config.JwtService;
import com.manug.security.repository.UserRepository;
import com.manug.security.user.Role;
import com.manug.security.user.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder,
      JwtService jwtService, AuthenticationManager authenticationManager) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtService = jwtService;
    this.authenticationManager = authenticationManager;
  }

  public AuthenticationResponse register(RegisterRequest registerRequest) {
    var user = new User();
    user.setFirstName(registerRequest.getFirstName())
        .setLastName(registerRequest.getLastName())
        .setEmail(registerRequest.getEmail())
        .setRole(Role.ROLE_USER);
    String password = passwordEncoder.encode(registerRequest.getPassword());
    user.setPassword(password);
    userRepository.save(user);

    var jwtToken = jwtService.generateToken(user);
    AuthenticationResponse authenticationResponse = new AuthenticationResponse();
    return authenticationResponse.setToken(jwtToken);
  }

  public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
            authenticationRequest.getPassword()));
    var user = userRepository.findByEmail(authenticationRequest.getEmail()).orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    AuthenticationResponse authenticationResponse = new AuthenticationResponse();
    return authenticationResponse.setToken(jwtToken);
  }

}

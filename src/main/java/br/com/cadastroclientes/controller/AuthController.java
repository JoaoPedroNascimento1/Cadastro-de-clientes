package br.com.cadastroclientes.controller;

import br.com.cadastroclientes.config.TokenService;
import br.com.cadastroclientes.documentation.AuthDocumentation;
import br.com.cadastroclientes.entity.User;
import br.com.cadastroclientes.mapper.UserMapper;
import br.com.cadastroclientes.repository.UserRepository;
import br.com.cadastroclientes.request.LoginRequest;
import br.com.cadastroclientes.request.UserRequest;
import br.com.cadastroclientes.response.LoginResponse;
import br.com.cadastroclientes.response.UserResponse;
import br.com.cadastroclientes.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController implements AuthDocumentation {

  private final UserService userService;
  private final AuthenticationManager authenticationManager;
  private final TokenService tokenService;

  @PostMapping("/register")
  public ResponseEntity<UserResponse> register(@Valid @RequestBody UserRequest userRequest) {
    return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(userService.save(UserMapper.toUser(userRequest))));
  }

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
    UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(loginRequest.email(),loginRequest.senha());
    Authentication authentication = authenticationManager.authenticate(userAndPass);

    String token = tokenService.generateToken((User) authentication.getPrincipal());
    return ResponseEntity.ok(new LoginResponse(token));
  }
}

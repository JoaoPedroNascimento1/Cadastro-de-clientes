package br.com.cadastroclientes.service;

import br.com.cadastroclientes.entity.User;
import br.com.cadastroclientes.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public User save(User user){
    user.setSenha(passwordEncoder.encode(user.getSenha()));
    return userRepository.save(user);
  }
}

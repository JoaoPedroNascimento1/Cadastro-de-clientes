package br.com.cadastroclientes.mapper;

import br.com.cadastroclientes.entity.User;
import br.com.cadastroclientes.request.UserRequest;
import br.com.cadastroclientes.response.UserResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

  public User toUser(UserRequest userRequest) {
    return User.builder()
      .nome(userRequest.nome())
      .email(userRequest.email())
      .senha(userRequest.senha())
      .role(userRequest.role())
      .build();
  }

  public UserResponse toUserResponse(User user) {
    return UserResponse.builder()
      .id(user.getId())
      .nome(user.getNome())
      .email(user.getEmail())
      .role(user.getRole())
      .build();
  }

}

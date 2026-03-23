package br.com.cadastroclientes.config;

import br.com.cadastroclientes.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TokenService {

  private String secret = "secret";

  public String generateToken(User user) {
    try{
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.create()
        .withIssuer("auth-api")
        .withClaim("userId", user.getId())
        .withSubject(user.getEmail())
        .withIssuedAt(Instant.now())
        .withExpiresAt(Instant.now().plusSeconds(86400))
        .sign(algorithm);
    } catch (JWTCreationException ex){
      throw new RuntimeException("Erro ao gerar token" + ex);
    }
  }

  public String validateToken(String token) {
    try{
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.require(algorithm)
        .withIssuer("auth-api")
        .build()
        .verify(token)
        .getSubject();
    } catch (JWTVerificationException ex){
      return "";
    }
  }
}

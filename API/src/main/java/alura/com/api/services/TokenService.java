package alura.com.api.services;

import alura.com.api.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
  @Value("${api.security.secret}")
  private String secret;

  public String generarToken(Usuario usuario){
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.create()
              .withIssuer("voll med")
              .withSubject(usuario.getNombre())
              .withClaim("id" , usuario.getId())
              .withExpiresAt(generarFechaExpiracion())
              .sign(algorithm);
    } catch (JWTCreationException exception){
      throw new RuntimeException();
    }
  }

  public String getSubject(String token){
    if (token == null) {
      throw new RuntimeException();
    }
    DecodedJWT verifier = null;
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret  ); // validando firma
      verifier = JWT.require(algorithm)
              .withIssuer("voll med")
              .build()
              .verify(token);
      verifier.getSubject();
    } catch (JWTVerificationException exception) {
      System.out.println(exception.toString());
    }
    if (verifier.getSubject() == null) {
      throw new RuntimeException("Verifier invalido");
    }
    return verifier.getSubject();
  }

  private Instant generarFechaExpiracion(){
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
  }
}

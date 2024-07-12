package alura.com.api.controller;

import alura.com.api.domain.usuario.DatosUsuarioAutenticadoDTO;
import alura.com.api.domain.usuario.Usuario;
import alura.com.api.infra.security.DatosDTOJWT;
import alura.com.api.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private TokenService tokenService;

  @PostMapping
  public ResponseEntity<?> autenticarUsuario(@RequestBody @Valid DatosUsuarioAutenticadoDTO datosUsuarioAutenticadoDTO) {
    UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(datosUsuarioAutenticadoDTO.nombre(), datosUsuarioAutenticadoDTO.contrasena());
    try {
      Authentication UsuarioAuthentication = authenticationManager.authenticate(authenticationToken);
      var jwtToken = tokenService.generarToken((Usuario)UsuarioAuthentication.getPrincipal());
      return ResponseEntity.ok(new DatosDTOJWT(jwtToken));
    } catch (AuthenticationException e) {
      return ResponseEntity.status(401).body("Error: " + e.getMessage());
    }
  }
}

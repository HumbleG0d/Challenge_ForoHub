package alura.com.api.infra.security;
import alura.com.api.repository.UsuarioRepository;
import alura.com.api.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

  @Autowired
  private TokenService tokenService;
  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    var authHeader = request.getHeader("Authorization");
    if (authHeader != null && authHeader.startsWith("Bearer ")) {
      var token = authHeader.replace("Bearer ", "");
      System.out.println("Token recibido: " + token);
      var nombreUsuario = tokenService.getSubject(token);
      System.out.println("Nombre de usuario del token: " + nombreUsuario);
      if (nombreUsuario != null) {
        var usuario = usuarioRepository.findByNombre(nombreUsuario).orElse(null);
        if (usuario != null) {
          var authentication = new UsernamePasswordAuthenticationToken(usuario, null,
                  usuario.getAuthorities());
          SecurityContextHolder.getContext().setAuthentication(authentication);
          System.out.println("Usuario autenticado: " + usuario.getNombre());
        } else {
          System.out.println("Usuario no encontrado en el repositorio");
        }
      } else {
        System.out.println("Nombre de usuario extraído del token es nulo");
      }
    } else {
      System.out.println("Header de autorización no encontrado o no comienza con 'Bearer '");
    }
    filterChain.doFilter(request, response);
  }
}
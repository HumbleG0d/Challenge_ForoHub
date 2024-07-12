package alura.com.api.services;

import alura.com.api.domain.usuario.Usuario;
import alura.com.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService implements UserDetailsService {

  @Autowired
  private UsuarioRepository usuarioRepository;
  @Override
  public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
    Usuario usuario = usuarioRepository.findByNombre(nombre).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado "+ nombre));
    return usuario;
  }
}

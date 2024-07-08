package alura.com.api.controller;

import alura.com.api.domain.usuario.DatosRegistroUsuariosDTO;
import alura.com.api.domain.usuario.DatosRespuestaUsuarioDTO;
import alura.com.api.domain.usuario.Usuario;
import alura.com.api.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @PostMapping
  public ResponseEntity<DatosRespuestaUsuarioDTO> agregarUsuario(@RequestBody @Valid DatosRegistroUsuariosDTO datosRegistroUsuariosDTO , UriComponentsBuilder uriComponentsBuilder){
  Usuario usuario =usuarioRepository.save(new Usuario(datosRegistroUsuariosDTO));
  DatosRespuestaUsuarioDTO datosRespuestaUsuarioDTO = new DatosRespuestaUsuarioDTO(usuario);
  URI url = uriComponentsBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
  return ResponseEntity.created(url).body(datosRespuestaUsuarioDTO);
  }

  @GetMapping("/{id}")
  public ResponseEntity<DatosRespuestaUsuarioDTO> buscarUsuario(@PathVariable Long id){
    Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
    if(usuarioOptional.isEmpty()){
      return ResponseEntity.notFound().build();
    }
    DatosRespuestaUsuarioDTO datosRespuestaUsuarioDTO = new DatosRespuestaUsuarioDTO(usuarioOptional.get());
    return ResponseEntity.ok(datosRespuestaUsuarioDTO);
  }

}

package alura.com.api.controller;

import alura.com.api.domain.curso.Curso;
import alura.com.api.domain.topico.*;
import alura.com.api.domain.usuario.Usuario;
import alura.com.api.repository.TopicoRepository;
import alura.com.api.repository.UsuarioRepository;
import alura.com.api.services.CursoService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

  @Autowired
  private TopicoRepository topicoRepository;

  @Autowired
  private CursoService cursoService;

  @Autowired
  private UsuarioRepository usuarioRepository;

  @PostMapping
  public ResponseEntity<DatosRespuestaTopicoDTO> obtenerTopicos(@Valid @RequestBody DatosTopicoDTO datosTopicoDTO) {

    Optional<Usuario> usuarioOptional = usuarioRepository.findByNombre(datosTopicoDTO.usuario().nombre());

    if(usuarioOptional.isEmpty()){
      return ResponseEntity.notFound().build();
    }

    Curso curso = new Curso(datosTopicoDTO.curso());
    curso = cursoService.save(curso);

    Topico topico = new Topico(datosTopicoDTO);
    topico.setUsuario(usuarioOptional.get());
    topico.setCurso(curso);
    topicoRepository.save(topico);

    DatosRespuestaTopicoDTO datosRespuestaTopicoDTO = new DatosRespuestaTopicoDTO(topico);
   return ResponseEntity.ok(datosRespuestaTopicoDTO);
  }

  @GetMapping
  public ResponseEntity<Page<DatosRespuestaTopicoDTO>> mostrarTopicos(@PageableDefault(size = 2) Pageable pageable){

    return ResponseEntity.ok(topicoRepository.getTopicos(pageable
    ).map(DatosRespuestaTopicoDTO::new));
  }

  @GetMapping("/{id}")
  public ResponseEntity<DatosRespuestaIdTopicoDTO> mostrarTopicoPorId(@PathVariable Long id){
    Optional<Topico> optionalTopico = topicoRepository.findById(id);

    if (optionalTopico.isEmpty()){
      return ResponseEntity.notFound().build();
    }

    var datosRespuestaTopico = new DatosRespuestaIdTopicoDTO(optionalTopico.get());
    return ResponseEntity.ok(datosRespuestaTopico);
  }

  @PutMapping
  @Transactional
  public ResponseEntity<DatosActualizarTopicoDTO> actualizarTopico(@Valid @RequestBody DatosActualizarTopicoDTO acualizarTopicoDTO){
    Optional<Topico> optionalTopico = topicoRepository.findById(acualizarTopicoDTO.id());
    if (optionalTopico.isEmpty()){
      return ResponseEntity.notFound().build();
    }
    var topico = optionalTopico.get();
    topico.actualizarTopico(acualizarTopicoDTO);

    return ResponseEntity.ok(acualizarTopicoDTO);
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<DatosRespuestaTopicoDTO> eliminarTopico(@PathVariable Long id){
    Optional<Topico> optionalTopico = topicoRepository.findById(id);
    if(optionalTopico.isEmpty()){
      return ResponseEntity.notFound().build();
    }
    var datosDeleteTopico = new DatosRespuestaTopicoDTO(optionalTopico.get());
    topicoRepository.deleteTopicoByid(id);
    return ResponseEntity.ok(datosDeleteTopico);
  }
}

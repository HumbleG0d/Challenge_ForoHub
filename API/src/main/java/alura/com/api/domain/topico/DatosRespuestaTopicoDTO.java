package alura.com.api.domain.topico;

import alura.com.api.domain.curso.Curso;
import alura.com.api.domain.usuario.Usuario;

public record DatosRespuestaTopicoDTO(
        Long id,
        String titulo,
        String mensaje,
        String fecha_creacion,
        String status,
        Curso curso
) {
  public DatosRespuestaTopicoDTO(Topico topico) {
    this(topico.getId(),topico.getTitulo(),topico.getMensaje() ,topico.getFecha_creacion().toString() , topico.getStatus().toString() ,topico.getCurso());
  }
}

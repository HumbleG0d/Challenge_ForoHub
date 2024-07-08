package alura.com.api.domain.topico;

import alura.com.api.domain.Status;
import alura.com.api.domain.curso.Curso;
import alura.com.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "Topico")
@Table(name = "topicos")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Topico {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String titulo;
  private String mensaje;
  private LocalDate fecha_creacion;
  @Enumerated(EnumType.STRING)
  private Status status;
  @ManyToOne
  @JoinColumn(name = "usuario_id" , nullable = false)
  private Usuario usuario;
  @ManyToOne
  @JoinColumn(name = "curso_id" , nullable = false)
  private Curso curso;

  public Topico(DatosTopicoDTO datosTopicoDTO){
    this.titulo  = datosTopicoDTO.titulo();
    this.mensaje = datosTopicoDTO.mensaje();
    this.fecha_creacion = LocalDate.parse(datosTopicoDTO.fecha_creacion());
    this.status = Status.valueOf(datosTopicoDTO.status());
    this.usuario = new Usuario(datosTopicoDTO.usuario());
    this.curso = new Curso(datosTopicoDTO.curso());
  }

  public void actualizarTopico(DatosActualizarTopicoDTO datosActualizarTopicoDTO){
    if(datosActualizarTopicoDTO.mensaje() != null){
      this.mensaje = datosActualizarTopicoDTO.mensaje();
    }
    if(datosActualizarTopicoDTO.status() != null){
    this.status = Status.valueOf(datosActualizarTopicoDTO.status());
    }
  }
}

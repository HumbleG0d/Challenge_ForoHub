package alura.com.api.domain.respuesta;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "Respuesta")
@Table(name = "respuestas")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Respuesta {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String mensaje;
  private Long topico_id;
  private LocalDate fecha_creacion;
  private Long usuario_id;
  private String solucion;
}

package alura.com.api.domain.topico;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "TopicoRespuesta")
@Table(name = "topico_respuestas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class TopicoRespuesta {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long topico_id;
  private Long respuesta_id;
}

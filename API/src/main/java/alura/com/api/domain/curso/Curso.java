package alura.com.api.domain.curso;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Curso")
@Table(name = "cursos")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Curso {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
  @Enumerated(EnumType.STRING)
  private Categoria categoria;

  public Curso(DatosCursoDTO curso) {
    this.nombre = curso.nombre();
    this.categoria = Categoria.valueOf(curso.categoria());
  }
}

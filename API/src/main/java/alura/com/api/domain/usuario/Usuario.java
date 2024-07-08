package alura.com.api.domain.usuario;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
  private String correo_electronico;
  private String contrasena;

  public Usuario(DatosRegistroUsuariosDTO datosRegistroUsuariosDTO) {
    this.nombre = datosRegistroUsuariosDTO.nombre();
    this.correo_electronico = datosRegistroUsuariosDTO.correo_electronico();
    this.contrasena = datosRegistroUsuariosDTO.contrasena();
  }

  public Usuario(DatosUsuarioDTO datosUsuarioDTO) {
    this.nombre = datosUsuarioDTO.nombre();
  }
}

package alura.com.api.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosUsuarioDTO(
        @NotBlank
        String nombre
) {
}

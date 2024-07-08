package alura.com.api.domain.topico;

import alura.com.api.domain.curso.DatosCursoDTO;
import alura.com.api.domain.usuario.DatosUsuarioDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosTopicoDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String fecha_creacion,
        @NotBlank
        String status,
        @NotNull
        DatosUsuarioDTO usuario,
        @NotNull
        DatosCursoDTO curso
) {
}

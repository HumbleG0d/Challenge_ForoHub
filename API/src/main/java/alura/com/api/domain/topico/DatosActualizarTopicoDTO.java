package alura.com.api.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopicoDTO(
        @NotNull
        Long id,

        @NotBlank
        String mensaje,

        @NotBlank
        String status
) {
}

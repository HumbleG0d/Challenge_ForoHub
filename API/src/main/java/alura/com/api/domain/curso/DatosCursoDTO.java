package alura.com.api.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosCursoDTO(
        @NotBlank
        String nombre,
        @NotBlank
        String categoria
) {
}

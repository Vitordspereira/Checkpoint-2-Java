package Maquiagem.Checkpoint2.dto.estoque;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CadastroEstoque(



        Integer quantidade,

        @NotBlank
        @Size(max = 100, message = "Nome do produto deve conter 100 caracteres")
        String nome,

        @NotBlank
        @Size(max = 100, message = "Marca deve conter 100 caracteres")
        String marca,

        Integer valor
        ) {
}

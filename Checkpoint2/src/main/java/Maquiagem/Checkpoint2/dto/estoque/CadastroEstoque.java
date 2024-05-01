package Maquiagem.Checkpoint2.dto.estoque;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroEstoque(

        @NotBlank
        @Size(max = 10, message = "Produto deve conter até 100 caracteres")
        Long produto,

        @NotBlank
        @Size(max = 5, message = "Quantidade deve ter até 5 caracteres")
        Integer quantidade
) {
}

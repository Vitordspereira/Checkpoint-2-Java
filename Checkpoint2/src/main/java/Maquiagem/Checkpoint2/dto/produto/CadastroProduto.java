package Maquiagem.Checkpoint2.dto.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CadastroProduto(

        @NotBlank
        @Size(max = 100, message = "Nome deve conter até 100 caracteres")
        String nome,

        @NotBlank
        @Size(max = 100, message = "Marca deve conter até 100 caracteres")
        String marca,

        
        Integer valor
) {
}

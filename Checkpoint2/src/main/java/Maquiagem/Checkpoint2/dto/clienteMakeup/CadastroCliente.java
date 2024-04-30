package Maquiagem.Checkpoint2.dto.clienteMakeup;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroCliente(
        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @NotBlank
        String email){

}

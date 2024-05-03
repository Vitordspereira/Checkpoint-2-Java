package Maquiagem.Checkpoint2.dto.fornecedor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroFornecedor(

        @NotBlank
        @Size(max = 100, message = "Nome deve conter 100 caracteres")
        String nome,
        @NotBlank
        @Size(max = 100, message = "Email deve conter 100 caracteres")
        String email,
        @NotBlank
        @Size(max = 15, message = "Telefone deve conter 15 caracteres")
        String telefone){
}
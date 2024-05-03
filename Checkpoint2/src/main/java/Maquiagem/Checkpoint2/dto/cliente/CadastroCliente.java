package Maquiagem.Checkpoint2.dto.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CadastroCliente(
        @NotBlank
        @Size(max = 100, message = "Nome deve conter 100 caracteres")
        String nome,
        @NotBlank
        @Size(max = 15, message = "CPF deve conter 15 caracteres")
        String telefone,
        @NotBlank
        @Size(max = 100, message = "E-mail deve conter 100 caracteres")
        String email,

        @NotBlank
        @Size(max = 5, message = "Quantidade de pedido deve conter 5 caracteres")
        Integer qtpedido,

        @NotBlank
        LocalDate compra
        ){

}

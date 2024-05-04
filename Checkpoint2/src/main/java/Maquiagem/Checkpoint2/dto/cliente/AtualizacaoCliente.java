package Maquiagem.Checkpoint2.dto.cliente;

import jakarta.validation.constraints.Size;

public record AtualizacaoCliente(

        @Size(max = 100)
        String nome,

        @Size(max = 15)
        String telefone,

        @Size(max = 100)
        String email
) {
}

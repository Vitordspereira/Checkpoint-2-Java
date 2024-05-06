package Maquiagem.Checkpoint2.dto.estoque;

import jakarta.validation.constraints.Size;

public record AtualizacaoEstoque(
        Integer quantidade
) {
}

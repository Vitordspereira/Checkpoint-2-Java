package Maquiagem.Checkpoint2.dto.estoque;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroEstoque(Long id, Long produto, Integer quantidade) {
}

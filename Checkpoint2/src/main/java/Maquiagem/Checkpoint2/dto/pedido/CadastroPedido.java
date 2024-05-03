package Maquiagem.Checkpoint2.dto.pedido;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Setter;

import java.time.LocalDate;

public record CadastroPedido(
        Integer qtpedido, LocalDate compra
) {
}

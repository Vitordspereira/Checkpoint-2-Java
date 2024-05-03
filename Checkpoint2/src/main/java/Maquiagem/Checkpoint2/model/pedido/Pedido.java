package Maquiagem.Checkpoint2.model.pedido;

import Maquiagem.Checkpoint2.dto.cliente.CadastroCliente;
import Maquiagem.Checkpoint2.model.cliente.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_PEDIDO")
@EntityListeners(AuditingEntityListener.class)
public class Pedido {

    @Id
    @GeneratedValue
    @Column(name = "ID_PEDIDO")
    private Long codigo;

    @Column(name = "QT_PEDIDO", length = 5)
    private Integer qtpedido;

    @Column(name = "DT_COMPRA")
    private LocalDate compra;

    @OneToOne
    @JoinColumn(name="ID_CLIENTE", nullable = false, unique = true)
    private Cliente cliente;
    public Pedido(CadastroCliente pedidoDto) {
        qtpedido = pedidoDto.qtpedido();
        compra = pedidoDto.compra();
    }

}

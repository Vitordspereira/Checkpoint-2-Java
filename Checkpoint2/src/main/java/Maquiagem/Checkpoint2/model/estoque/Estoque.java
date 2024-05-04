package Maquiagem.Checkpoint2.model.estoque;

import Maquiagem.Checkpoint2.dto.cliente.AtualizacaoCliente;
import Maquiagem.Checkpoint2.dto.cliente.CadastroCliente;
import Maquiagem.Checkpoint2.dto.estoque.CadastroEstoque;
import Maquiagem.Checkpoint2.model.pedido.Pedido;
import Maquiagem.Checkpoint2.model.produto.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_ESTOQUE_MAKEUP")
@EntityListeners(AuditingEntityListener.class)
public class Estoque {

    @Id
    @GeneratedValue
    @Column(name = "ID_ESTOQUE")
    private Long codigo;


    @Column(name = "QT_ESTOQUE", length = 5)
    private Integer quantidade;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Produto produto;

    public Estoque(CadastroEstoque estoqueDto) {

        quantidade = estoqueDto.quantidade();
    }




}

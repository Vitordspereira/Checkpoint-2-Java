package Maquiagem.Checkpoint2.model.estoque;

import Maquiagem.Checkpoint2.dto.estoque.CadastroEstoque;
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

    @Column(name = "ID_PRODUTO", length = 10)
    private Long produto;

    @Column(name = "QT_ESTOQUE", length = 5)
    private Integer quantidade;

    public Estoque(CadastroEstoque estoqueDto) {
        produto = estoqueDto.produto();
        quantidade = estoqueDto.quantidade();
    }
}

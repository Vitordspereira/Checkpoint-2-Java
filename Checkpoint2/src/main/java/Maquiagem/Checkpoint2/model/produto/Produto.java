package Maquiagem.Checkpoint2.model.produto;

import Maquiagem.Checkpoint2.dto.cliente.CadastroCliente;
import Maquiagem.Checkpoint2.dto.estoque.CadastroEstoque;
import Maquiagem.Checkpoint2.dto.produto.CadastroProduto;
import Maquiagem.Checkpoint2.model.cliente.Cliente;
import Maquiagem.Checkpoint2.model.estoque.Estoque;
import Maquiagem.Checkpoint2.model.fornecedor.Fornecedor;
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
@Table(name = "TB_PRODUTO")
@EntityListeners(AuditingEntityListener.class)
public class Produto {

    @Id
    @GeneratedValue
    @Column(name = "ID_PRODUTO")
    private Long codigo;

    @Column(name = "NM_PRODUTO", length = 100)
    private String nome;

    @Column(name = "DS_MARCA", length = 100)
    private String marca;

    @Column(name = "VL_PRODUTO", length = 5)
    private Integer valor;

    @ManyToOne
    @JoinColumn(name = "ID_FORNECEDOR", nullable = false)
    private Fornecedor fornecedor;

    @OneToOne
    @JoinColumn(name="ID_ESTOQUE", nullable = false, unique = true)
    private Estoque estoque;

    public Produto(CadastroEstoque produtoDto) {
        nome = produtoDto.nome();
        marca = produtoDto.marca();
        valor = produtoDto.valor();
        this.fornecedor = fornecedor;
    }

}

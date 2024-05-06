package Maquiagem.Checkpoint2.model.fornecedor;

import Maquiagem.Checkpoint2.dto.estoque.CadastroEstoque;
import Maquiagem.Checkpoint2.dto.fornecedor.CadastroFornecedor;
import Maquiagem.Checkpoint2.model.produto.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_FORNECEDOR")
@EntityListeners(AuditingEntityListener.class)
public class Fornecedor {

    @Id
    @GeneratedValue
    @Column(name = "ID_FORNECEDOR")
    private Long codigo;

    @Column(name = "NM_FORNECEDOR", length = 100)
    private String nome;

    @Column(name = "DS_EMAIL", length = 100)
    private String email;

    @Column(name = "NR_FORNECEDOR", length = 15)
    private String telefone;

    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    private List<Produto> produtos;

    public Fornecedor(CadastroFornecedor fornecedorDto) {
        nome = fornecedorDto.nome();
        email = fornecedorDto.email();
        telefone = fornecedorDto.telefone();
    }
}

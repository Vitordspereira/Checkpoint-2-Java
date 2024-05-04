package Maquiagem.Checkpoint2.model.cliente;

import Maquiagem.Checkpoint2.dto.cliente.AtualizacaoCliente;
import Maquiagem.Checkpoint2.dto.cliente.CadastroCliente;
import Maquiagem.Checkpoint2.model.pedido.Pedido;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "TB_CLIENTE_MAKEUP")
@EntityListeners(AuditingEntityListener.class)
public class Cliente {

    @Id
    @GeneratedValue
    @Column(name = "ID_CLIENTE")
    private Long codigo;

    @Column(name = "NM_CLIENTE", length = 100)
    private String nome;

    @Column(name = "NR_TELEFONE", length = 15)
    private String telefone;

    @Column(name = "DS_EMAIL", length = 100)
    private String email;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Pedido pedido;

    public Cliente(CadastroCliente clienteDto) {
        nome = clienteDto.nome();
        telefone = clienteDto.telefone();
        email = clienteDto.email();
        pedido = new Pedido(clienteDto);
        pedido.setCliente(this);
    }

    public void atualizar(AtualizacaoCliente  clienteDto) {
        if (clienteDto.nome() != null){
            this.nome = clienteDto.nome();
        }
        if (clienteDto.telefone() != null){
            this.telefone = clienteDto.telefone();
        }
        if (clienteDto.email() != null){
            this.email = clienteDto.email();
        }
    }
}
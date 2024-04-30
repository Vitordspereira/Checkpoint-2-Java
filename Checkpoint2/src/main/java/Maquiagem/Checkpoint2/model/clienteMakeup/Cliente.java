package Maquiagem.Checkpoint2.model.clienteMakeup;

import Maquiagem.Checkpoint2.dto.clienteMakeup.CadastroCliente;
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


    public Cliente(CadastroCliente clienteDto) {
        nome = clienteDto.nome();
        telefone = clienteDto.telefone();
        email = clienteDto.email();
    }
}

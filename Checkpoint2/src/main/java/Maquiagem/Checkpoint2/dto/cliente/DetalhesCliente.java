package Maquiagem.Checkpoint2.dto.cliente;

import Maquiagem.Checkpoint2.model.cliente.Cliente;

import java.time.LocalDate;

public record DetalhesCliente(Long id, String nome, String telefone, String email,
                              Integer qtpedido, LocalDate compra) {

    public DetalhesCliente(Cliente cliente){
        this(cliente.getCodigo(), cliente.getNome(), cliente.getTelefone(), cliente.getEmail(),
                 cliente.getPedido().getQtpedido(), cliente.getPedido().getCompra());
    }
}

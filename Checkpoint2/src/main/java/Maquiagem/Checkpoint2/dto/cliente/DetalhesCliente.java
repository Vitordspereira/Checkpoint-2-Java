package Maquiagem.Checkpoint2.dto.cliente;

import Maquiagem.Checkpoint2.model.cliente.Cliente;

public record DetalhesCliente(Long id, String nome, String telefone, String email) {

    public DetalhesCliente(Cliente cliente){
        this(cliente.getCodigo(), cliente.getNome(), cliente.getTelefone(), cliente.getEmail());
    }
}

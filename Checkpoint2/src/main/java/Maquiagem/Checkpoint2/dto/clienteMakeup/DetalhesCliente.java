package Maquiagem.Checkpoint2.dto.clienteMakeup;

import Maquiagem.Checkpoint2.model.clienteMakeup.Cliente;

public record DetalhesCliente(Long id, String nome, String telefone, String email) {

    public DetalhesCliente(Cliente cliente){
        this(cliente.getCodigo(), cliente.getNome(), cliente.getTelefone(), cliente.getEmail());
    }
}

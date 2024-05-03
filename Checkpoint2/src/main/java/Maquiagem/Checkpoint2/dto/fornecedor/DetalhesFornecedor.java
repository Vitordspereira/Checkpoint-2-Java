package Maquiagem.Checkpoint2.dto.fornecedor;

import Maquiagem.Checkpoint2.model.fornecedor.Fornecedor;

public record DetalhesFornecedor(Long id, String nome, String email, String telefone) {

    public DetalhesFornecedor(Fornecedor fornecedor){
        this(fornecedor.getCodigo(), fornecedor.getNome(), fornecedor.getEmail(), fornecedor.getTelefone());{

        }
    }
}

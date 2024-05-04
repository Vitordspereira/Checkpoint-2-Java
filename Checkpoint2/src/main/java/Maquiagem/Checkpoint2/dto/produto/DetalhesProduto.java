package Maquiagem.Checkpoint2.dto.produto;

import Maquiagem.Checkpoint2.dto.fornecedor.DetalhesFornecedor;
import Maquiagem.Checkpoint2.model.produto.Produto;

public record DetalhesProduto(Long id, String nome, String marca, Integer valor,
                              DetalhesFornecedor fornecedor) {

    public DetalhesProduto(Produto produto){

        this(produto.getCodigo(),produto.getNome(), produto.getMarca(), produto.getValor(),
                new DetalhesFornecedor(produto.getFornecedor()));
    }
}

package Maquiagem.Checkpoint2.dto.produto;

import Maquiagem.Checkpoint2.model.produto.Produto;

public record DetalhesProduto(String nome, String marca, Integer valor) {

    public DetalhesProduto(Produto produto){
        this(produto.getNome(), produto.getMarca(), produto.getValor());
    }
}

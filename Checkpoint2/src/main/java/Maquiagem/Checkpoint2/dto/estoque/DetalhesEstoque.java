package Maquiagem.Checkpoint2.dto.estoque;

import Maquiagem.Checkpoint2.model.estoque.Estoque;

public record DetalhesEstoque(Long id, Integer quantidade, String nome,
                              String marca, Integer valor) {

    public DetalhesEstoque(Estoque estoque){

        this(estoque.getCodigo(), estoque.getQuantidade(), estoque.getProduto().getNome(),
                estoque.getProduto().getMarca(), estoque.getProduto().getValor());
    }
}

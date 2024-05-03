package Maquiagem.Checkpoint2.dto.estoque;

import Maquiagem.Checkpoint2.model.estoque.Estoque;

public record DetalhesEstoque(Long id, Long produto, Integer quantidade) {

    public DetalhesEstoque(Estoque estoque){
        this(estoque.getCodigo(), estoque.getProduto(), estoque.getQuantidade());
    }
}

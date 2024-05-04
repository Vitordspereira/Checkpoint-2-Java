package Maquiagem.Checkpoint2.dto.pedido;

import Maquiagem.Checkpoint2.model.pedido.Pedido;

import java.time.LocalDate;

public record DetalhesPedido(Long codigo, Integer qtpedido, LocalDate compra) {

    public DetalhesPedido(Pedido pedido){

        this(pedido.getCodigo(), pedido.getQtpedido(), pedido.getCompra());
    }
}

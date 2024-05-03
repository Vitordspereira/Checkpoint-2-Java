package Maquiagem.Checkpoint2.controller.pedido;

import Maquiagem.Checkpoint2.dto.cliente.CadastroCliente;
import Maquiagem.Checkpoint2.dto.cliente.DetalhesCliente;
import Maquiagem.Checkpoint2.dto.estoque.DetalhesEstoque;
import Maquiagem.Checkpoint2.dto.pedido.CadastroPedido;
import Maquiagem.Checkpoint2.dto.pedido.DetalhesPedido;
import Maquiagem.Checkpoint2.model.cliente.Cliente;
import Maquiagem.Checkpoint2.model.pedido.Pedido;
import Maquiagem.Checkpoint2.repository.cliente.ClienteRepository;
import Maquiagem.Checkpoint2.repository.pedido.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public ResponseEntity<List<DetalhesPedido>> get(Pageable pageable){
        var lista = pedidoRepository.findAll(pageable).stream().map(DetalhesPedido::new).toList();
        return ResponseEntity.ok(lista);
    }
    @GetMapping("{id}")
    public ResponseEntity<DetalhesPedido> get(@PathVariable("id") Long id){
        var pedido = pedidoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesPedido(pedido));
    }
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesPedido> cadastrar(@RequestBody @Valid CadastroPedido pedidoDto,
                                                    UriComponentsBuilder uriBuilder) {
        var pedido = new Pedido(pedidoDto);
        pedidoRepository.save(pedido);
        var url = uriBuilder.path("pedidos/{codigo}").buildAndExpand(pedido.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesPedido(pedido));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        pedidoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
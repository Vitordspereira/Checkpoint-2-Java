package Maquiagem.Checkpoint2.controller.cliente;

import Maquiagem.Checkpoint2.dto.cliente.CadastroCliente;
import Maquiagem.Checkpoint2.dto.cliente.DetalhesCliente;
import Maquiagem.Checkpoint2.model.cliente.Cliente;
import Maquiagem.Checkpoint2.repository.cliente.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity<List<DetalhesCliente>> get(Pageable pageable){
        var lista = clienteRepository.findAll(pageable).stream().map(DetalhesCliente::new).toList();
        return ResponseEntity.ok(lista);
    }
    @GetMapping("{id}")
    public ResponseEntity<DetalhesCliente> get(@PathVariable("id") Long id){
        var cliente = clienteRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesCliente(cliente));
    }


    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesCliente> cadastrar(@RequestBody @Valid CadastroCliente clienteDto,
                                                     UriComponentsBuilder uriBuilder){
        var cliente = new Cliente(clienteDto);
        clienteRepository.save(cliente);
        var url = uriBuilder.path("clientes/{codigo}").buildAndExpand(cliente.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesCliente(cliente));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

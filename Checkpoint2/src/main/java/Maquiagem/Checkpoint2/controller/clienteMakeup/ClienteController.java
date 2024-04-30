package Maquiagem.Checkpoint2.controller.clienteMakeup;

import Maquiagem.Checkpoint2.dto.clienteMakeup.CadastroCliente;
import Maquiagem.Checkpoint2.dto.clienteMakeup.DetalhesCliente;
import Maquiagem.Checkpoint2.model.clienteMakeup.Cliente;
import Maquiagem.Checkpoint2.repository.clienteMakeup.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesCliente> cadastrar(@RequestBody @Valid CadastroCliente clienteDto,
                                                     UriComponentsBuilder uriBuilder){
        var cliente = new Cliente(clienteDto);
        clienteRepository.save(cliente);
        var url = uriBuilder.path("clientes/{codigo}").buildAndExpand(cliente.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesCliente(cliente));
    }

}

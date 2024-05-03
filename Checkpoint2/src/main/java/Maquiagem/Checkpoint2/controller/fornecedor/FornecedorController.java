package Maquiagem.Checkpoint2.controller.fornecedor;

import Maquiagem.Checkpoint2.dto.fornecedor.CadastroFornecedor;
import Maquiagem.Checkpoint2.dto.fornecedor.DetalhesFornecedor;
import Maquiagem.Checkpoint2.model.fornecedor.Fornecedor;
import Maquiagem.Checkpoint2.repository.fornecedor.FornecedorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @GetMapping
    public ResponseEntity<List<DetalhesFornecedor>> get(Pageable pageable){
        var lista = fornecedorRepository.findAll(pageable).stream().map(DetalhesFornecedor::new).toList();
        return ResponseEntity.ok(lista);
    }
    @GetMapping("{id}")
    public ResponseEntity<DetalhesFornecedor> get(@PathVariable("id") Long id){
        var fornecedor = fornecedorRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesFornecedor(fornecedor));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesFornecedor> cadastrar(@RequestBody @Valid CadastroFornecedor fornecedorDto,
                                                        UriComponentsBuilder uriBuilder) {
        var fornecedor = new Fornecedor(fornecedorDto);
        fornecedorRepository.save(fornecedor);
        var url = uriBuilder.path("fornecedores/{codigo}").buildAndExpand(fornecedor.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesFornecedor(fornecedor));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        fornecedorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
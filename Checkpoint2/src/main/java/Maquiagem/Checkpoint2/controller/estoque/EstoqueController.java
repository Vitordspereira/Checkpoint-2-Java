package Maquiagem.Checkpoint2.controller.estoque;

import Maquiagem.Checkpoint2.dto.estoque.CadastroEstoque;
import Maquiagem.Checkpoint2.dto.estoque.DetalhesEstoque;
import Maquiagem.Checkpoint2.model.estoque.Estoque;
import Maquiagem.Checkpoint2.repository.estoque.EstoqueRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("estoques")
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @GetMapping
    public ResponseEntity<List<DetalhesEstoque>> get(Pageable pageable){
        var lista = estoqueRepository.findAll(pageable).stream().map(DetalhesEstoque::new).toList();
        return ResponseEntity.ok(lista);
    }
    @GetMapping("{id}")
    public ResponseEntity<DetalhesEstoque> get(@PathVariable("id") Long id){
        var estoque = estoqueRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesEstoque(estoque));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesEstoque> cadastrar(@RequestBody @Valid CadastroEstoque estoqueDto,
                                                     UriComponentsBuilder uriBuilder) {
        var estoque = new Estoque(estoqueDto);
        estoqueRepository.save(estoque);
        var url = uriBuilder.path("estoques/{codigo}").buildAndExpand(estoque.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesEstoque(estoque));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        estoqueRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
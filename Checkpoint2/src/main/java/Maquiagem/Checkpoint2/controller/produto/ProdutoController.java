package Maquiagem.Checkpoint2.controller.produto;

import Maquiagem.Checkpoint2.dto.cliente.CadastroCliente;
import Maquiagem.Checkpoint2.dto.cliente.DetalhesCliente;
import Maquiagem.Checkpoint2.dto.estoque.DetalhesEstoque;
import Maquiagem.Checkpoint2.dto.produto.CadastroProduto;
import Maquiagem.Checkpoint2.dto.produto.DetalhesProduto;
import Maquiagem.Checkpoint2.model.cliente.Cliente;
import Maquiagem.Checkpoint2.model.produto.Produto;
import Maquiagem.Checkpoint2.repository.cliente.ClienteRepository;
import Maquiagem.Checkpoint2.repository.produto.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<DetalhesProduto>> get(Pageable pageable){
        var lista = produtoRepository.findAll(pageable).stream().map(DetalhesProduto::new).toList();
        return ResponseEntity.ok(lista);
    }
    @GetMapping("{id}")
    public ResponseEntity<DetalhesProduto> get(@PathVariable("id") Long id){
        var produto = produtoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesProduto(produto));
    }
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesProduto> cadastrar(@RequestBody @Valid CadastroProduto produtoDto,
                                                     UriComponentsBuilder uriBuilder) {
        var produto = new Produto(produtoDto);
        produtoRepository.save(produto);
        var url = uriBuilder.path("produtos/{codigo}").buildAndExpand(produto.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesProduto(produto));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
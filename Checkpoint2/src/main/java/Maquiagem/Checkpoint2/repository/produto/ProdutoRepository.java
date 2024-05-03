package Maquiagem.Checkpoint2.repository.produto;

import Maquiagem.Checkpoint2.model.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

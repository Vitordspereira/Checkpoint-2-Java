package Maquiagem.Checkpoint2.repository.estoque;

import Maquiagem.Checkpoint2.model.estoque.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}

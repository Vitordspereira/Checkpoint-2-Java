package Maquiagem.Checkpoint2.repository.clienteMakeup;

import Maquiagem.Checkpoint2.model.clienteMakeup.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

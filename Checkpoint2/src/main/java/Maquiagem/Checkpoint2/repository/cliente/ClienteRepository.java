package Maquiagem.Checkpoint2.repository.cliente;

import Maquiagem.Checkpoint2.model.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

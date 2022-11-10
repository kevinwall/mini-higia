package br.jus.jfrn.minihigia.repository;

import br.jus.jfrn.minihigia.model.Doenca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoencaRepository extends JpaRepository<Doenca, Long> {
}

package br.jus.jfrn.minihigia.repository;

import br.jus.jfrn.minihigia.model.Comorbidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComorbidadeRepository extends JpaRepository<Comorbidade, Long> {
}

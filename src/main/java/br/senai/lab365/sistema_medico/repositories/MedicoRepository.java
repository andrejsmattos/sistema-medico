package br.senai.lab365.sistema_medico.repositories;

import br.senai.lab365.sistema_medico.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long>{
}

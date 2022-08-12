package br.com.tiacademy.sca.repository;

import org.springframework.stereotype.Repository;

import br.com.tiacademy.sca.core.crud.CrudRepository;
import br.com.tiacademy.sca.domain.Disciplina;

@Repository
public interface DisciplinaRepository extends CrudRepository<Disciplina, Long> {

}

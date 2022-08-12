package br.com.tiacademy.sca.repository;

import org.springframework.stereotype.Repository;

import br.com.tiacademy.sca.core.crud.CrudRepository;
import br.com.tiacademy.sca.domain.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long> {

}

package br.com.tiacademy.sca.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tiacademy.sca.core.crud.CrudRepository;
import br.com.tiacademy.sca.domain.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long> {

	/*
	 * @Query(value = "select a from Curso c where c.nome = :nome") Curso
	 * consultarPeloNome(@Param("nome") String nome);
	 * 
	 * Curso findByNome(String nome);
	 */
}

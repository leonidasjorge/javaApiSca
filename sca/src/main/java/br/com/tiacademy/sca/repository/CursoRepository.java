package br.com.tiacademy.sca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.tiacademy.sca.core.crud.CrudRepository;
import br.com.tiacademy.sca.domain.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long> {

	// Query HQL
	@Query(value = "select c from Curso c where c.nome = ?1")
	Curso consultaCurso(String nome);
	
	// Query Nativa
	@Query(value = "select * from curso order by nome", nativeQuery = true)
	List<Curso> findByAllSortNomeCurso();

	// Query Spring Data
	Curso findByNome(String nome);
}

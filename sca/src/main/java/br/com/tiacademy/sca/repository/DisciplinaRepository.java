package br.com.tiacademy.sca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.tiacademy.sca.core.crud.CrudRepository;
import br.com.tiacademy.sca.domain.Disciplina;

@Repository
public interface DisciplinaRepository extends CrudRepository<Disciplina, Long> {

	// Query HQL
	@Query(value = "select d from Disciplina d where d.nome = ?1")
	Disciplina consultaDisciplina(String nome);
	
	// Query Nativa
	@Query(value = "select * from disciplina order by nome", nativeQuery = true)
	List<Disciplina> findByAllSortNomeDisciplina();
		
	// Query Spring Data
	Disciplina findByNome(String nome);
	
	// Query Spring Data
	List<Disciplina> findByIdIn(List<Long> ids);
	
}

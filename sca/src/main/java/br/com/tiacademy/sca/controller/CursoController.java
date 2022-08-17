package br.com.tiacademy.sca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.sca.core.crud.CrudController;
import br.com.tiacademy.sca.domain.Curso;
import br.com.tiacademy.sca.dto.CursoDTO;
import br.com.tiacademy.sca.repository.CursoRepository;

@RestController
@RequestMapping("/curso")
public class CursoController extends CrudController<Curso, CursoDTO, Long> {

	@Autowired
	protected CursoRepository repository;
	
	// EndPoint - Query HQL
	@GetMapping(path = "/consulta/{nome}")
	public ResponseEntity<Curso> buscarCurso(@PathVariable String nome) {
		return ResponseEntity.ok(repository.consultaCurso(nome));
	}
	
	// EndPoint - Query Nativa
	@GetMapping("/cursosOrdenadosPorNome")
	public ResponseEntity<List<Curso>> cursosOrdemNome() {
		List<Curso> cursoOrdemPorNome = repository.findByAllSortNomeCurso();
		return ResponseEntity.ok(cursoOrdemPorNome);
	}
			
	// EndPoint - Query Spring Data
	@GetMapping("/listar/{nome}")
	public Curso listarNomeCurso(@PathVariable String nome) {
		return repository.findByNome(nome);
	}
}

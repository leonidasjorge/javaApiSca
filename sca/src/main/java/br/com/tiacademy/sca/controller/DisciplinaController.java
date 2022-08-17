package br.com.tiacademy.sca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.sca.core.crud.CrudController;
import br.com.tiacademy.sca.domain.Disciplina;
import br.com.tiacademy.sca.dto.DisciplinaDTO;
import br.com.tiacademy.sca.repository.DisciplinaRepository;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController extends CrudController<Disciplina, DisciplinaDTO, Long> {

	@Autowired
	protected DisciplinaRepository repository;
	
	// EndPoint - Query HQL
	@GetMapping(path = "/consulta/{nome}")
	public ResponseEntity<Disciplina> buscarDisciplina(@PathVariable String nome) {
		return ResponseEntity.ok(repository.consultaDisciplina(nome));
	}
	
	// EndPoing - Query Nativa
	@GetMapping("/disciplinasOrdenadasPorNome")
	public ResponseEntity<List<Disciplina>> disciplinasOrdemNome() {
		List<Disciplina> disciplinaOrdemPorNome = repository.findByAllSortNomeDisciplina();
		return ResponseEntity.ok(disciplinaOrdemPorNome);
	}
	
	// EndPoint - Query Spring Data
	@GetMapping("/nome/{nome}")
	public Disciplina listarNomeDisciplina(@PathVariable String nome) {
		return repository.findByNome(nome);
	}

}

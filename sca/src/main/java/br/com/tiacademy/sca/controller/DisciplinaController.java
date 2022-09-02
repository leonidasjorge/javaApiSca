package br.com.tiacademy.sca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tiacademy.sca.converter.DisciplinaConverter;
import br.com.tiacademy.sca.core.crud.ReadController;
import br.com.tiacademy.sca.domain.Disciplina;
import br.com.tiacademy.sca.dto.DisciplinaCriarDTO;
import br.com.tiacademy.sca.dto.DisciplinaDTO;
import br.com.tiacademy.sca.repository.DisciplinaRepository;
import br.com.tiacademy.sca.service.DisciplinaService;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController extends ReadController<Disciplina, DisciplinaDTO, Long> {

	@Autowired
	protected DisciplinaRepository repository;
	
	private DisciplinaConverter getConverter() {
		return (DisciplinaConverter) converter;
	}
	
	private DisciplinaService getService() {
		return (DisciplinaService) service;
	}	
	
	@PostMapping
	public ResponseEntity<DisciplinaDTO> criar(@RequestBody DisciplinaCriarDTO dto) {
		
		var disciplina = getConverter().dtoCriarParaEntidade(dto);
		
		var salvar = getService().criarDisciplina(disciplina, dto);
		
		ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();
		
		var uri = builder.path("/{id}").buildAndExpand(salvar.getId()).toUri();
		
		return ResponseEntity.created(uri).body(converter.entidadeParaDTO(salvar));
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<DisciplinaDTO> editar(@PathVariable("id") Long id, @RequestBody DisciplinaDTO dto) {
		
		var novaEntidade = getConverter().dtoParaEntidade(dto);
		var salvar = getService().editar(id, novaEntidade);
		
		return ResponseEntity.ok(getConverter().entidadeParaDTO(salvar));
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		
		getService().excluir(id);
		
		return ResponseEntity.noContent().build();
	}	
	
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

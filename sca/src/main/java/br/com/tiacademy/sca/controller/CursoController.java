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

import br.com.tiacademy.sca.converter.CursoConverter;
import br.com.tiacademy.sca.core.crud.ReadController;
import br.com.tiacademy.sca.domain.Curso;
import br.com.tiacademy.sca.dto.CursoCriarDTO;
import br.com.tiacademy.sca.dto.CursoDTO;
import br.com.tiacademy.sca.repository.CursoRepository;
import br.com.tiacademy.sca.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController extends ReadController<Curso, CursoDTO, Long> {

	@Autowired
	protected CursoRepository repository;
	
	private CursoConverter getConverter() {
		return (CursoConverter) converter;
	}
	
	private CursoService getService() {
		return (CursoService) service;
	}
	
	@PostMapping
	public ResponseEntity<CursoDTO> criar(@RequestBody CursoCriarDTO dto) {
		
		var curso = getConverter().dtoCriarParaEntidade(dto);
		
		var salvar = getService().criarCurso(curso, dto);
		
		ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();
		
		var uri = builder.path("/{id}").buildAndExpand(salvar.getId()).toUri();
		
		return ResponseEntity.created(uri).body(converter.entidadeParaDTO(salvar));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CursoDTO> editar(@PathVariable("id") Long id, @RequestBody CursoDTO dto) {
		
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

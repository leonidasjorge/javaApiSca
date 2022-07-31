package br.com.tiacademy.sca.controller;

import java.util.List;
import java.util.Objects;

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

import br.com.tiacademy.sca.domain.Disciplina;
import br.com.tiacademy.sca.service.DisciplinaService;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;
	
	@GetMapping
	public ResponseEntity<List<Disciplina>> listar() {
		var disciplinas = disciplinaService.listar();
		return ResponseEntity.ok(disciplinas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Disciplina> especifico(@PathVariable("id") Long id) {
		
		var resultado = disciplinaService.porId(id);
		
		if (Objects.isNull(resultado)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(resultado);
	}
	
	@PostMapping
	public ResponseEntity<Disciplina> criar(@RequestBody Disciplina disciplina) {
		var salva = disciplinaService.criar(disciplina);
		return ResponseEntity.ok(salva);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Disciplina> editar(@PathVariable("id") Long id, @RequestBody Disciplina disciplina) {
		return ResponseEntity.ok(disciplinaService.editar(id, disciplina));
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		disciplinaService.excluir(id);
		return ResponseEntity.ok().build();
	}
	
}

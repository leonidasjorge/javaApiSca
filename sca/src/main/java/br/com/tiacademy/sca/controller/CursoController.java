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

import br.com.tiacademy.sca.domain.Curso;
import br.com.tiacademy.sca.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@GetMapping
	public ResponseEntity<List<Curso>> listar() {
		var cursos = cursoService.listar();
		return ResponseEntity.ok(cursos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Curso> especifico(@PathVariable("id") Long id) {
		
		var resultado = cursoService.porId(id);
		
		if (Objects.isNull(resultado)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(resultado);
	}
	
	@PostMapping
	public ResponseEntity<Curso> criar(@RequestBody Curso curso) {
		var salvo = cursoService.criar(curso);
		return ResponseEntity.ok(salvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Curso> editar(@PathVariable("id") Long id, @RequestBody Curso curso) {
		return ResponseEntity.ok(cursoService.editar(id, curso));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		cursoService.excluir(id);
		return ResponseEntity.ok().build();
	}
	
}

package br.com.tiacademy.sca.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	/*
	 * @Autowired public CursoRepository repository;
	 * 
	 * @GetMapping("/nome/{nome}") public Curso listarNome(@PathVariable String
	 * nome) { return repository.findByNome(nome); }
	 */
}

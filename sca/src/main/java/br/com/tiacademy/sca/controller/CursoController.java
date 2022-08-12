package br.com.tiacademy.sca.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.sca.core.crud.CrudController;
import br.com.tiacademy.sca.domain.Curso;

@RestController
@RequestMapping("/curso")
public class CursoController extends CrudController<Curso, Long> {
	
}

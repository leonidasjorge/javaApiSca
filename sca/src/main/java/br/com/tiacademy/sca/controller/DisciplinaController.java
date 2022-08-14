package br.com.tiacademy.sca.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.sca.core.crud.CrudController;
import br.com.tiacademy.sca.domain.Disciplina;
import br.com.tiacademy.sca.dto.DisciplinaDTO;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController extends CrudController<Disciplina, DisciplinaDTO, Long> {

}

package br.com.tiacademy.sca.service;

import org.springframework.stereotype.Service;

import br.com.tiacademy.sca.core.crud.CrudService;
import br.com.tiacademy.sca.domain.Disciplina;

@Service
public class DisciplinaService extends CrudService<Disciplina, Long> {

	@Override
	protected Disciplina editarEntidade(Disciplina recuperado, Disciplina entidade) {
		recuperado.setNome(entidade.getNome());
		recuperado.setCarga_horaria(entidade.getCarga_horaria());
		recuperado.setData_cadastro(entidade.getData_cadastro());
		return recuperado;
	}
	
}

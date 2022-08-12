package br.com.tiacademy.sca.service;

import org.springframework.stereotype.Service;

import br.com.tiacademy.sca.core.crud.CrudService;
import br.com.tiacademy.sca.domain.Disciplina;

@Service
public class DisciplinaService extends CrudService<Disciplina, Long> {

	@Override
	protected Disciplina editarEntidade(Disciplina recuperado, Disciplina entidade) {
		recuperado.setNome(entidade.getNome());
		return recuperado;
	}
	
}

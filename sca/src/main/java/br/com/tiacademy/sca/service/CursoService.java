package br.com.tiacademy.sca.service;

import org.springframework.stereotype.Service;

import br.com.tiacademy.sca.core.crud.CrudService;
import br.com.tiacademy.sca.domain.Curso;

@Service
public class CursoService extends CrudService<Curso, Long> {
	
	@Override
	protected Curso editarEntidade(Curso recuperado, Curso entidade) {
		
		recuperado.setNome(entidade.getNome());
		recuperado.setCargaHoraria(entidade.getCargaHoraria());
		recuperado.setDataCadastro(entidade.getDataCadastro());
		
		return recuperado;
	}
	
}

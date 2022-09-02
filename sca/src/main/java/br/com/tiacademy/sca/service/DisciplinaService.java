package br.com.tiacademy.sca.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import br.com.tiacademy.sca.core.crud.CrudService;
import br.com.tiacademy.sca.domain.Disciplina;
import br.com.tiacademy.sca.dto.DisciplinaCriarDTO;

@Service
public class DisciplinaService extends CrudService<Disciplina, Long> {

	public Disciplina criarDisciplina(Disciplina disciplina, DisciplinaCriarDTO dto) {
		
		disciplina.setCargaHoraria(dto.getCargaHoraria());
		disciplina.setDataCadastro(LocalDate.now());
		disciplina.setNome(dto.getNome());

		return super.criar(disciplina);
	}
	
	@Override
	protected Disciplina editarEntidade(Disciplina recuperado, Disciplina entidade) {
		
		recuperado.setId(entidade.getId());
		recuperado.setCargaHoraria(entidade.getCargaHoraria());
		recuperado.setDataCadastro(entidade.getDataCadastro());
		recuperado.setNome(entidade.getNome());
		
		return recuperado;
	}
	
}

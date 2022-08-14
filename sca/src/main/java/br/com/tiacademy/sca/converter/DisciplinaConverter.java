package br.com.tiacademy.sca.converter;

import org.springframework.stereotype.Component;

import br.com.tiacademy.sca.core.crud.CrudConverter;
import br.com.tiacademy.sca.domain.Disciplina;
import br.com.tiacademy.sca.dto.DisciplinaDTO;

@Component
public class DisciplinaConverter implements CrudConverter<Disciplina, DisciplinaDTO> {

	@Override
	public DisciplinaDTO entidadeParaDTO(Disciplina entidade) {
		return new DisciplinaDTO(entidade.getId(), entidade.getNome(), entidade.getData_cadastro(),
				entidade.getCarga_horaria());
	}

	/*
	 * @Override public Disciplina dtoParaEntidade(DisciplinaDTO dto) { return new
	 * Disciplina(dto.getId(), dto.getNome(), dto.getData_cadastro(),
	 * dto.getCarga_horaria()); }
	 */

	@Override
	public Disciplina dtoParaEntidade(DisciplinaDTO dto) {

		var disciplina = new Disciplina();

		disciplina.setId(dto.getId());
		disciplina.setNome(dto.getNome());
		disciplina.setCarga_horaria(dto.getCarga_horaria());
		disciplina.setData_cadastro(dto.getData_cadastro());

		return disciplina;
	}

}

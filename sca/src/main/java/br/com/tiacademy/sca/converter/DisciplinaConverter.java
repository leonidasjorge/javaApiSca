package br.com.tiacademy.sca.converter;

import org.springframework.stereotype.Component;

import br.com.tiacademy.sca.core.crud.CrudConverter;
import br.com.tiacademy.sca.domain.Disciplina;
import br.com.tiacademy.sca.dto.DisciplinaCriarDTO;
import br.com.tiacademy.sca.dto.DisciplinaDTO;

@Component
public class DisciplinaConverter implements CrudConverter<Disciplina, DisciplinaDTO> {

	@Override
	public DisciplinaDTO entidadeParaDTO(Disciplina entidade) {
		
		return new DisciplinaDTO(entidade.getId(),
								 entidade.getCargaHoraria(),
								 entidade.getDataCadastro(),
								 entidade.getNome());
	}

	@Override
	public Disciplina dtoParaEntidade(DisciplinaDTO dto) {
		
		return new Disciplina(dto.getId(),
							  dto.getCargaHoraria(),
							  dto.getDataCadastro(),
							  dto.getNome());
	}

	public Disciplina dtoCriarParaEntidade(DisciplinaCriarDTO dto) {
		
		var disciplina = new Disciplina();
		
		return disciplina;
	}	
	
}

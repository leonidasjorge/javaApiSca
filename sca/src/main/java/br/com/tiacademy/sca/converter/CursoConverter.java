package br.com.tiacademy.sca.converter;

import org.springframework.stereotype.Component;

import br.com.tiacademy.sca.core.crud.CrudConverter;
import br.com.tiacademy.sca.domain.Curso;
import br.com.tiacademy.sca.dto.CursoDTO;

@Component
public class CursoConverter implements CrudConverter<Curso, CursoDTO> {

	@Override
	public CursoDTO entidadeParaDTO(Curso entidade) {
		return new CursoDTO(entidade.getId(), entidade.getCargaHoraria(), entidade.getDataCadastro(), entidade.getNome(), entidade.getDisciplinas());
	}

	@Override
	public Curso dtoParaEntidade(CursoDTO dto) {
		return new Curso(dto.getId(), dto.getCargaHoraria(), dto.getDataCadastro(), dto.getNome(), dto.getDisciplinas());
	}

}

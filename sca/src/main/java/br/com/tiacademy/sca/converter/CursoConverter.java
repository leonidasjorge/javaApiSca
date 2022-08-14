package br.com.tiacademy.sca.converter;

import org.springframework.stereotype.Component;

import br.com.tiacademy.sca.core.crud.CrudConverter;
import br.com.tiacademy.sca.domain.Curso;
import br.com.tiacademy.sca.dto.CursoDTO;

@Component
public class CursoConverter implements CrudConverter<Curso, CursoDTO> {

	@Override
	public CursoDTO entidadeParaDTO(Curso entidade) {
		
		var dto = new CursoDTO();
		
		dto.setId(entidade.getId());
		dto.setNome(entidade.getNome());
		dto.setCarga_horaria(entidade.getCarga_horaria());
		dto.setData_cadastro(entidade.getData_cadastro());
		
		return dto;
	}

	@Override
	public Curso dtoParaEntidade(CursoDTO dto) {
		
		var curso = new Curso();
		
		curso.setId(dto.getId());
		curso.setNome(dto.getNome());
		curso.setCarga_horaria(dto.getCarga_horaria());
		curso.setData_cadastro(dto.getData_cadastro());
		
		return curso;
	}

}

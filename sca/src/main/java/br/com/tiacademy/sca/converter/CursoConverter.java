package br.com.tiacademy.sca.converter;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.tiacademy.sca.core.crud.CrudConverter;
import br.com.tiacademy.sca.domain.Curso;
import br.com.tiacademy.sca.dto.CursoCriarDTO;
import br.com.tiacademy.sca.dto.CursoDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CursoConverter implements CrudConverter<Curso, CursoDTO> {

	private final DisciplinaConverter disciplinaConverter;
	
	@Override
	public CursoDTO entidadeParaDTO(Curso entidade) {
		
		var dto = new CursoDTO();
		
		dto.setId(entidade.getId());
		dto.setCargaHoraria(entidade.getCargaHoraria());
		dto.setDataCadastro(entidade.getDataCadastro());
		dto.setNome(entidade.getNome());
		
		dto.getDisciplinasDTO().addAll(entidade.getDisciplinas().stream()
															  	.map(this.disciplinaConverter::entidadeParaDTO)
															  	.collect(Collectors.toList()));
		
		return dto;
	}

	@Override
	public Curso dtoParaEntidade(CursoDTO dto) {
		
		var curso = new Curso();
		
		curso.setId(dto.getId());
		curso.setCargaHoraria(dto.getCargaHoraria());
		curso.setDataCadastro(dto.getDataCadastro());
		curso.setNome(dto.getNome());
		
		var colecaoDeDisciplinas = dto.getDisciplinasDTO().stream()
														  .map(this.disciplinaConverter::dtoParaEntidade)
														  .collect(Collectors.toList());
		
		curso.getDisciplinas().addAll(colecaoDeDisciplinas);
		
		return curso;		
	}

	public Curso dtoCriarParaEntidade(CursoCriarDTO dto) {
		
		var curso = new Curso();
		
		return curso;
	}	
	
}

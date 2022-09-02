package br.com.tiacademy.sca.service;

import java.time.LocalDate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.tiacademy.sca.core.crud.CrudService;
import br.com.tiacademy.sca.domain.Curso;
import br.com.tiacademy.sca.dto.CursoCriarDTO;
import br.com.tiacademy.sca.dto.CursoDisciplinaDTO;
import br.com.tiacademy.sca.repository.DisciplinaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CursoService extends CrudService<Curso, Long> {
	
	private final DisciplinaRepository disciplinaRepository;
	
	public Curso criarCurso(Curso curso, CursoCriarDTO dto) {

		var ids = dto.getDisciplinasDTO().stream().map(CursoDisciplinaDTO::getId).collect(Collectors.toList());
				
		var disciplinas = disciplinaRepository.findByIdIn(ids);
		
		curso.setCargaHoraria(dto.getCargaHoraria());
		curso.setDataCadastro(LocalDate.now());
		curso.setNome(dto.getNome());
		curso.getDisciplinas().addAll(disciplinas);

		return super.criar(curso);
	}
	
	@Override
	protected Curso editarEntidade(Curso recuperado, Curso entidade) {
		
		recuperado.setId(entidade.getId());
		recuperado.setCargaHoraria(entidade.getCargaHoraria());
		recuperado.setDataCadastro(entidade.getDataCadastro());
		recuperado.setNome(entidade.getNome());
		
		recuperado.getDisciplinas().clear();
		recuperado.getDisciplinas().addAll(entidade.getDisciplinas());
		
		return recuperado;
	}
	
}

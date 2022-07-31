package br.com.tiacademy.sca.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiacademy.sca.domain.Disciplina;
import br.com.tiacademy.sca.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	public List<Disciplina> listar() {
		return disciplinaRepository.findAll();
	}
	
	public Disciplina porId(Long id) {
		return disciplinaRepository.findById(id).orElse(null);
	}	
	
	public Disciplina criar(Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}

	public Disciplina editar(Long id, Disciplina editado) {
		var recuperado = porId(id);
		
		if(Objects.isNull(recuperado)) {
			throw new RuntimeException("Não foi encontrada.");
		}
		
		recuperado.setNome(editado.getNome());
		
		return disciplinaRepository.save(recuperado);
	}
	
	public void excluir(Long id) {
		disciplinaRepository.deleteById(id);
	}
	
}

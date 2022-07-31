package br.com.tiacademy.sca.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiacademy.sca.domain.Curso;
import br.com.tiacademy.sca.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	public List<Curso> listar() {
		return cursoRepository.findAll();
	}
	
	public Curso porId(Long id) {
		return cursoRepository.findById(id).orElse(null);
	}
	
	public Curso criar(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	public Curso editar(Long id, Curso editado) {
		var recuperado = porId(id);
		
		if(Objects.isNull(recuperado)) {
			throw new RuntimeException("Não foi encontrado.");
		}
		
		recuperado.setNome(editado.getNome());
		
		return cursoRepository.save(recuperado);
	}
	
	public void excluir(Long id) {
		cursoRepository.deleteById(id);
	}
	
}

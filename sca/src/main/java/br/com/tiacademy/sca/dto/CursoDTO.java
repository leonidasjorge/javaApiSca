package br.com.tiacademy.sca.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CursoDTO implements Serializable {

	private Long id;
	
	private String cargaHoraria;
	
	private LocalDate dataCadastro;
	
	private String nome;
	
	private List<DisciplinaDTO> disciplinasDTO = new ArrayList<>();
	
}

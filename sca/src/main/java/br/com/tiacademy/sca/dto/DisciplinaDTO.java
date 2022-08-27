package br.com.tiacademy.sca.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DisciplinaDTO implements Serializable {

	private Long id;
	
	private String cargaHoraria;
	
	private LocalDate dataCadastro;
	
	private String nome;
}

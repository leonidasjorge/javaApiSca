package br.com.tiacademy.sca.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DisciplinaCriarDTO implements Serializable {

	private String cargaHoraria;
	private String nome;
	
}

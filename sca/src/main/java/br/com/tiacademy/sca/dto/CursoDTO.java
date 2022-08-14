package br.com.tiacademy.sca.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CursoDTO implements Serializable {

	private Long id;
	private String carga_horaria;
	private Date data_cadastro;
	private String nome;
	
}

package br.com.tiacademy.sca.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CursoCriarDTO implements Serializable {

	private String cargaHoraria;
	private String nome;
	
	private List<CursoDisciplinaDTO> disciplinasDTO = new ArrayList<>();
	
}

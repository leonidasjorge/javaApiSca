package br.com.tiacademy.sca.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import br.com.tiacademy.sca.core.crud.CrudDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Curso implements CrudDomain<Long>, Serializable {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@Column(name = "carga_horaria")
	private String cargaHoraria;
	
	@Column(name = "data_cadastro")
	private LocalDate dataCadastro;
	
	private String nome;

	@ManyToMany
	@JoinTable(name = "curso_disciplina",
			   joinColumns = @JoinColumn(name = "curso_id"),
			   inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
	private List<Disciplina> disciplinas = new ArrayList<>();

}

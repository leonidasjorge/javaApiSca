package br.com.tiacademy.sca.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.com.tiacademy.sca.core.crud.CrudDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Disciplina implements CrudDomain<Long>, Serializable {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String carga_horaria;
	private Date data_cadastro;	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "curso_id", referencedColumnName = "id")
	private Curso curso;
}

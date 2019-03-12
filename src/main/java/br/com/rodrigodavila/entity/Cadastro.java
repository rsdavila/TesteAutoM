package br.com.rodrigodavila.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cadastro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cadastros_sequence")
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "nome", length = 50, nullable = false)
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

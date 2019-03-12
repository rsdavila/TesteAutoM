package br.com.rodrigodavila.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Historico {

	@Id
	@Column(name = "id_cadastro", nullable = false)
	private Integer id;

	@Column(name = "valor", length = 50, nullable = false)
	private String valor;

	public Integer getId() {
		return id;
	}

	public void setIdHistorico(Integer id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}

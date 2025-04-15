package com.inter.SistemaDeCadastro.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Escolaridade")
public class EscolaridadeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long codEscolaridade;
	
	@Column(length = 100, nullable = false)
	private String nm_Escolaridade;
	
	@Column(length = 1, nullable = false)
	private char status;
	
	public EscolaridadeModel() {
	}

	public Long getCodEscolaridade() {
		return codEscolaridade;
	}

	public void setCodEscolaridade(Long codEscolaridade) {
		this.codEscolaridade = codEscolaridade;
	}

	public String getNm_Escolaridade() {
		return nm_Escolaridade;
	}

	public void setNm_Escolaridade(String nm_Escolaridade) {
		this.nm_Escolaridade = nm_Escolaridade;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	
	
}

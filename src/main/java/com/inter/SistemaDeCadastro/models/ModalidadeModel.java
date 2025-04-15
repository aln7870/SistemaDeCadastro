package com.inter.SistemaDeCadastro.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Modalidade")
public class ModalidadeModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long codModalidade;
	
	@Column(length = 50, nullable = false)
	private String nm_Modalidade;
	
	@Column(length = 1, nullable = false)
	private char status;
	
	public ModalidadeModel() {
    }

	public Long getCodModalidade() {
		return codModalidade;
	}

	public void setCodModalidade(Long codModalidade) {
		this.codModalidade = codModalidade;
	}

	public String getNm_Modalidade() {
		return nm_Modalidade;
	}

	public void setNm_Modalidade(String nm_Modalidade) {
		this.nm_Modalidade = nm_Modalidade;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

}

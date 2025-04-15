package com.inter.SistemaDeCadastro.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Aluno")
public class ControleFaltaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long codControleFalta;
	
	@Column(length = 1, nullable = false)
	private char falta;
	
	@Column(updatable = false)
    private Date dataFalta;
	
	@ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
	private UserModel user;
	
	@ManyToOne
    @JoinColumn(name = "codInscricaoModalidade", nullable = false)
	private InscricaoModalidadeModel inscricaoModalidade;
	
	@Column(length = 1, nullable = false)
	private char status;

	public Long getCodControleFalta() {
		return codControleFalta;
	}

	public void setCodControleFalta(Long codControleFalta) {
		this.codControleFalta = codControleFalta;
	}

	public char getFalta() {
		return falta;
	}

	public void setFalta(char falta) {
		this.falta = falta;
	}

	public Date getDataFalta() {
		return dataFalta;
	}

	public void setDataFalta(Date dataFalta) {
		this.dataFalta = dataFalta;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public InscricaoModalidadeModel getInscricaoModalidade() {
		return inscricaoModalidade;
	}

	public void setInscricaoModalidade(InscricaoModalidadeModel inscricaoModalidade) {
		this.inscricaoModalidade = inscricaoModalidade;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	
	
}

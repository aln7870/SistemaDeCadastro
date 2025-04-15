package com.inter.SistemaDeCadastro.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Contato")
public class ContatoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long codContato;
	
	@Column(length = 80, nullable = false)
	private String responsavelEmergencial;
	
	@Column(length = 17, nullable = false)
	private String telefonePrincipal;
	
	@Column(length = 17, nullable = false)
	private String telefoneEmergencial;
	
	@Column(length = 150, nullable = false)
	private String email;
	
	@ManyToOne
    @JoinColumn(name = "codAluno", nullable = false)
	private AlunoModel aluno;
	
	@Column(length = 1, nullable = false)
	private char status;
	
	public ContatoModel() {
		
	}

	public Long getCodContato() {
		return codContato;
	}

	public void setCodContato(Long codContato) {
		this.codContato = codContato;
	}

	public String getResponsavelEmergencial() {
		return responsavelEmergencial;
	}

	public void setResponsavelEmergencial(String responsavelEmergencial) {
		this.responsavelEmergencial = responsavelEmergencial;
	}

	public String getTelefonePrincipal() {
		return telefonePrincipal;
	}

	public void setTelefonePrincipal(String telefonePrincipal) {
		this.telefonePrincipal = telefonePrincipal;
	}

	public String getTelefoneEmergencial() {
		return telefoneEmergencial;
	}

	public void setTelefoneEmergencial(String telefoneEmergencial) {
		this.telefoneEmergencial = telefoneEmergencial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public AlunoModel getCodAluno() {
		return aluno;
	}

	public void setCodAluno(AlunoModel aluno) {
		this.aluno = aluno;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
}

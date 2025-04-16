package com.inter.SistemaDeCadastro.models;


import java.sql.Date;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Aluno")
public class AlunoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INT UNSIGNED AUTO_INCREMENT")
	private Long codAluno;
	
	@Column(length = 150, nullable = false)
	private String nm_Aluno;
	
	@Column(updatable = false)
    private Date dt_Nascimento;
	
	@Column(length = 1, columnDefinition = "CHAR(1) DEFAULT NULL")
    @Pattern(regexp = "[MF]")
    private String sexo;
	
	@Column(length = 14, nullable = false)
	private String cpf;
	
	
	@Column(length = 10, nullable = false)
	private String rg;
	
	
	@Column(length = 1, columnDefinition = "CHAR(1) DEFAULT NULL")
    @Pattern(regexp = "[]")
	private char nacionalidade;
	
	
    @Column(nullable = false)
	private Long codEscolaridade;
	
	@Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime dt_Cadastro;
	
	@Column(length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
	    @Pattern(regexp = "[AI]")
	    private String status = "A";

	    @PrePersist
	    public void prePersist() {
	        if (status == null) {
	            status = "A";
	        }
	    }
	
	public AlunoModel() {
    }
	
	public Long getCodAluno() {
		return codAluno;
	}

	public void setCodAluno(Long codAluno) {
		this.codAluno = codAluno;
	}
	
	public String getNomeAluno() {
		return nm_Aluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nm_Aluno = nomeAluno;
	}
	public Date getDataNasc() {
		return dt_Nascimento;
	}
	public void setDataNasc(Date dataNasc) {
		this.dt_Nascimento = dataNasc;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public char getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(char nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public Long getCodEsc() {
		return codEscolaridade;
	}
	public void setCodEsc(Long codEsc) {
		this.codEscolaridade = codEsc;
	}
	public LocalDateTime getDataCadast() {
		return dt_Cadastro;
	}
	public void setDataCadast(LocalDateTime dataCadast) {
		this.dt_Cadastro = dataCadast;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus (String status) {
		this.status = status;
	}

}

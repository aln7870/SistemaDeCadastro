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
@Table(name = "Familiar")
public class FamiliarModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long codFamiliar;
	
	@Column(length = 150, nullable = false)
	private String nm_Familiar;
	
	@Column(updatable = false)
    private Date dt_Nascimento;
	
	@ManyToOne
    @JoinColumn(name = "codAluno", nullable = false)
	private AlunoModel aluno;
	
	@ManyToOne
    @JoinColumn(name = "codOpcao", nullable = false)
	private OcupacaoModel ocupacao;
	
	@ManyToOne
    @JoinColumn(name = "codEscolaridade", nullable = false)
	private EscolaridadeModel escolaridade;
	
	@Column(length = 1, nullable = false)
	private char status;
	
	public FamiliarModel(){
		
	}

	public Long getCodFamiliar() {
		return codFamiliar;
	}

	public void setCodFamiliar(Long codFamiliar) {
		this.codFamiliar = codFamiliar;
	}

	public String getNm_Familiar() {
		return nm_Familiar;
	}

	public void setNm_Familiar(String nm_Familiar) {
		this.nm_Familiar = nm_Familiar;
	}

	public Date getDt_Nascimento() {
		return dt_Nascimento;
	}

	public void setDt_Nascimento(Date dt_Nascimento) {
		this.dt_Nascimento = dt_Nascimento;
	}

	public AlunoModel getAluno() {
		return aluno;
	}

	public void setAluno(AlunoModel aluno) {
		this.aluno = aluno;
	}

	public OcupacaoModel getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(OcupacaoModel ocupacao) {
		this.ocupacao = ocupacao;
	}

	public EscolaridadeModel getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(EscolaridadeModel escolaridade) {
		this.escolaridade = escolaridade;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	

}

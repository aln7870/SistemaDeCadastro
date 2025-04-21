package com.inter.SistemaDeCadastro.models;

import java.sql.Date;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Familiar")
public class FamiliarModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CodFamiliar")
	private Integer codFamiliar;
	
	@Column(name = "Nm_Familiar",length = 150, nullable = false)
	private String nome;
	
	@Column(name = "Dt_Nascimento",updatable = false)
    private Date dataNasc;



	@Column(name = "Parentesco",length = 40, nullable = false, columnDefinition = "VARCHAR(40)")
	private String parentesco;
	
	@ManyToOne
    @JoinColumn(name = "CodAluno", nullable = false)
	private AlunoModel aluno;
	
	@ManyToOne
    @JoinColumn(name = "CodOcupacao", nullable = false)
	private OcupacaoModel ocupacao;
	
	@ManyToOne
    @JoinColumn(name = "CodEscolaridade", nullable = false)
	private EscolaridadeModel escolaridade;
	
	@Column(name = "Status",length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
    @Pattern(regexp = "[AI]")
    private String status;

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = "A";
        }
    }


	public Integer getCodFamiliar() {
		return codFamiliar;
	}

	public void setCodFamiliar(Integer codFamiliar) {
		this.codFamiliar = codFamiliar;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
}

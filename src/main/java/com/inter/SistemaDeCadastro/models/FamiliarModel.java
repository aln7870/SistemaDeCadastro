package com.inter.SistemaDeCadastro.models;

import java.sql.Date;

import com.inter.SistemaDeCadastro.models.enums.ParentescoEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Familiar")
public class FamiliarModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codFamiliar;
	
	@Column(length = 150, nullable = false)
	private String nmFamiliar;
	
	@Column(updatable = false)
    private Date dtNascimento;

	@Enumerated(EnumType.STRING)
	@Column(length = 30, nullable = false)
	private ParentescoEnum parentesco;
	
	@ManyToOne
    @JoinColumn(name = "codAluno", nullable = false)
	private AlunoModel aluno;
	
	@ManyToOne
    @JoinColumn(name = "codOcupacao", nullable = false)
	private OcupacaoModel ocupacao;
	
	@ManyToOne
    @JoinColumn(name = "codEscolaridade", nullable = false)
	private EscolaridadeModel escolaridade;
	
	@Column(length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
    @Pattern(regexp = "[AI]")
    private String status = "A";

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = "A";
        }
    }


	public Long getCodFamiliar() {
		return codFamiliar;
	}

	public void setCodFamiliar(Long codFamiliar) {
		this.codFamiliar = codFamiliar;
	}

	public String getNmFamiliar() {
		return nmFamiliar;
	}

	public void setNmFamiliar(String nm_Familiar) {
		this.nmFamiliar = nm_Familiar;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
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

	public ParentescoEnum getParentesco() {
		return parentesco;
	}

	public void setParentesco(ParentescoEnum parentesco) {
		this.parentesco = parentesco;
	}
}

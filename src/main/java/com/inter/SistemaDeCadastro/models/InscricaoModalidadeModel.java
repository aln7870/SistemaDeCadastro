package com.inter.SistemaDeCadastro.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "InscricaoModalidade")
public class InscricaoModalidadeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CodInscricaoModalidade")
	private Integer codInscricaoModalidade;

	@ManyToOne
    @JoinColumn(name = "CodAluno", nullable = false)
	private AlunoModel aluno;

	@ManyToOne
    @JoinColumn(name = "CodModalidade", nullable = false)
    private ModalidadeModel modalidade;

	@ManyToOne
    @JoinColumn(name = "CodTurno", nullable = false)
	private TurnoModel turno;

	@Column(name = "Status",length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
	@Pattern(regexp = "[AI]")
	private String status;

	@PrePersist
	public void prePersist() {
		if (status == null) {
			status = "A";
		}
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCodInscricaoModalidade() {
		return codInscricaoModalidade;
	}

	public void setCodInscricaoModalidade(Integer codInscricaoModalidade) {
		this.codInscricaoModalidade = codInscricaoModalidade;
	}

	public AlunoModel getAluno() {
		return aluno;
	}

	public void setAluno(AlunoModel aluno) {
		this.aluno = aluno;
	}

	public ModalidadeModel getModalidade() {
		return modalidade;
	}

	public void setModalidade(ModalidadeModel modalidade) {
		this.modalidade = modalidade;
	}

	public TurnoModel getTurno() {
		return turno;
	}

	public void setTurno(TurnoModel turno) {
		this.turno = turno;
	}
}

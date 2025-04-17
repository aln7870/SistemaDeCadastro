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
@Table(name = "InscricaoModalidade")
public class InscricaoModalidadeModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codInscricaoModalidade;
	

	@ManyToOne
    @JoinColumn(name = "codAluno", nullable = false)
	private AlunoModel aluno;
	
	@ManyToOne
    @JoinColumn(name = "codModalidade", nullable = false)
    private ModalidadeModel modalidade;
	
	@ManyToOne
    @JoinColumn(name = "codTurno", nullable = false)
	private TurnoModel turno;

	public Long getCodInscricaoModalidade() {
		return codInscricaoModalidade;
	}

	public void setCodInscricaoModalidade(Long codInscricaoModalidade) {
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

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
	@Column(nullable = false)
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

	public AlunoModel getCodAluno() {
		return aluno;
	}

	public void setCodAluno(AlunoModel aluno) {
		this.aluno = aluno;
	}

	public ModalidadeModel getCodModalidade() {
        return modalidade;
    }

    public void setCodModalidade(ModalidadeModel modalidade) {
        this.modalidade = modalidade;
    }

	public TurnoModel getCodTurno() {
		return turno;
	}

	public void setCodTurno(TurnoModel turno) {
		this.turno = turno;
	}
	
	

}

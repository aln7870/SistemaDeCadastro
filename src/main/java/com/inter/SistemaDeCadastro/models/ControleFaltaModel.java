package com.inter.SistemaDeCadastro.models;

import java.sql.Date;

import com.inter.SistemaDeCadastro.models.enums.NacionalidadeAlunoEnum;
import com.inter.SistemaDeCadastro.models.enums.StatusFaltaEnum;
import com.inter.SistemaDeCadastro.models.enums.TipoFaltaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "ControleFalta")
public class ControleFaltaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codControleFalta;
	
	@Column(name = "Falta" ,length = 1, columnDefinition = "CHAR(1) DEFAULT 'P'")
    @Pattern(regexp = "[PF]")
    private String falta = "P";
	
	@Column(name = "DataFalta" ,updatable = false)
    private Date dataFalta;
	
	@ManyToOne
    @JoinColumn(name = "CodAluno", nullable = false)
	private AlunoModel aluno;
	
	@ManyToOne
    @JoinColumn(name = "codInscricaoModalidade", nullable = false)
	private InscricaoModalidadeModel inscricaoModalidade;

	@Column(name = "StatusFalta", columnDefinition = "ENUM('PENDENTE', 'CONFIRMADO') DEFAULT 'PENDENTE'")
	@Enumerated(EnumType.STRING)
	private StatusFaltaEnum statusFalta;

	@Column(name = "TipoFalta", columnDefinition = "ENUM('REFORCO', 'MODALIDADE')")
	@Enumerated(EnumType.STRING)
	private TipoFaltaEnum tipoFalta;
	
	@Column(name = "Status", length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
    @Pattern(regexp = "[AI]")
    private String status = "A";

	@PrePersist
	public void prePersist() {
		if (falta == null) {
			falta = "P";
		}
		if (status == null) {
			status = "A";
		}
	}

	public Long getCodControleFalta() {
		return codControleFalta;
	}

	public void setCodControleFalta(Long codControleFalta) {
		this.codControleFalta = codControleFalta;
	}

	public String getFalta() {
		return falta;
	}

	public void setFalta(String falta) {
		this.falta = falta;
	}

	public Date getDataFalta() {
		return dataFalta;
	}

	public void setDataFalta(Date dataFalta) {
		this.dataFalta = dataFalta;
	}

	public InscricaoModalidadeModel getInscricaoModalidade() {
		return inscricaoModalidade;
	}

	public void setInscricaoModalidade(InscricaoModalidadeModel inscricaoModalidade) {
		this.inscricaoModalidade = inscricaoModalidade;
	}

	public StatusFaltaEnum getStatusFalta() {
		return statusFalta;
	}

	public void setStatusFalta(StatusFaltaEnum statusFalta) {
		this.statusFalta = statusFalta;
	}

	public TipoFaltaEnum getTipoFalta() {
		return tipoFalta;
	}

	public void setTipoFalta(TipoFaltaEnum tipoFalta) {
		this.tipoFalta = tipoFalta;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AlunoModel getAluno() {
		return aluno;
	}

	public void setAluno(AlunoModel aluno) {
		this.aluno = aluno;
	}
}


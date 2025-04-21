package com.inter.SistemaDeCadastro.models;

import java.sql.Date;
import java.time.LocalDateTime;

import com.inter.SistemaDeCadastro.models.enums.TipoFaltaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "ControleFalta")
public class ControleFaltaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CodControleFalta")
	private Integer codControleFalta;
	
	@Column(name = "Falta" ,length = 1, columnDefinition = "CHAR(1) DEFAULT 'P'")
    @Pattern(regexp = "[PF]")
    private String falta;
	
	@Column(name = "DataFalta" ,updatable = false)
	@CreationTimestamp
    private LocalDateTime dataFalta;

	// não tem no banco, alterar dps
/*	@ManyToOne
    @JoinColumn(name = "CodAluno", nullable = false)
	private AlunoModel aluno;
*/
	@ManyToOne
    @JoinColumn(name = "CodInscricaoModalidade", nullable = false)
	private InscricaoModalidadeModel inscricaoModalidade;

	@Column(name = "TipoFalta", columnDefinition = "ENUM('REFORCO', 'MODALIDADE')")
	@Enumerated(EnumType.STRING)
	private TipoFaltaEnum tipoFalta;
	
	@Column(name = "Status", length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
    @Pattern(regexp = "[AI]")
    private String status;

	@PrePersist
	public void prePersist() {
		if (falta == null) {
			falta = "P";
		}
		if (status == null) {
			status = "A";
		}
	}

	public Integer getCodControleFalta() {
		return codControleFalta;
	}

	public void setCodControleFalta(Integer codControleFalta) {
		this.codControleFalta = codControleFalta;
	}

	public String getFalta() {
		return falta;
	}

	public void setFalta(String falta) {
		this.falta = falta;
	}

	public InscricaoModalidadeModel getInscricaoModalidade() {
		return inscricaoModalidade;
	}

	public void setInscricaoModalidade(InscricaoModalidadeModel inscricaoModalidade) {
		this.inscricaoModalidade = inscricaoModalidade;
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

}


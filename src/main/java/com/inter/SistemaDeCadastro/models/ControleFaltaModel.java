package com.inter.SistemaDeCadastro.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Aluno")
public class ControleFaltaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INT UNSIGNED AUTO_INCREMENT")
	private Long codControleFalta;
	
	@Column(length = 1, columnDefinition = "CHAR(1) DEFAULT 'P'")
    @Pattern(regexp = "[PF]")
    private String falta = "P";
	
	@Column(updatable = false)
    private Date dataFalta;
	
	@ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
	@Column(columnDefinition = "INT UNSIGNED")
	private UserModel user;
	
	@ManyToOne
    @JoinColumn(name = "codInscricaoModalidade", nullable = false)
	@Column(columnDefinition = "INT UNSIGNEDT")
	private InscricaoModalidadeModel inscricaoModalidade;
	
	public enum tipoFalta {
		REFORCO,
		MODALIDADE;
	}
	
	public enum statusFalta{
		PENDENTE,
		CONFIRMADO;
	}
	
	@Column(length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
    @Pattern(regexp = "[AI]")
    private String status = "A";
	
	//PrePersist aqui
	@PrePersist
    public void prePersistFalta() {
        if (falta == null) {
            falta = "P";
        }
    }

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = "A";
        }
    }
    
    public ControleFaltaModel() {
    	
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

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public InscricaoModalidadeModel getInscricaoModalidade() {
		return inscricaoModalidade;
	}

	public void setInscricaoModalidade(InscricaoModalidadeModel inscricaoModalidade) {
		this.inscricaoModalidade = inscricaoModalidade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}

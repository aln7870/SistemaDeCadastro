package com.inter.SistemaDeCadastro.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Escolaridade")
public class EscolaridadeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CodEscolaridade")
	private Integer codEscolaridade;
	
	@Column(name = "Nm_Escolaridade",length = 100, nullable = false)
	private String nome;
	
	@Column(name = "Status",length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
    @Pattern(regexp = "[AI]")
    private String status = "A";

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = "A";
        }
    }
	
	public EscolaridadeModel() {
	}

	public Integer getCodEscolaridade() {
		return codEscolaridade;
	}

	public void setCodEscolaridade(Integer codEscolaridade) {
		this.codEscolaridade = codEscolaridade;
	}

	public String getNm_Escolaridade() {
		return nome;
	}

	public void setNm_Escolaridade(String nm_Escolaridade) {
		this.nome = nm_Escolaridade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}

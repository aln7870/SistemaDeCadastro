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
	@Column(columnDefinition = "INT UNSIGNED AUTO_INCREMENT")
	private Long codEscolaridade;
	
	@Column(length = 100, nullable = false)
	private String nm_Escolaridade;
	
	@Column(length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
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

	public Long getCodEscolaridade() {
		return codEscolaridade;
	}

	public void setCodEscolaridade(Long codEscolaridade) {
		this.codEscolaridade = codEscolaridade;
	}

	public String getNm_Escolaridade() {
		return nm_Escolaridade;
	}

	public void setNm_Escolaridade(String nm_Escolaridade) {
		this.nm_Escolaridade = nm_Escolaridade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}

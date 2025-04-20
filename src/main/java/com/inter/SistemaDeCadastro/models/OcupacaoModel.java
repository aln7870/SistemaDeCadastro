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
@Table(name = "Ocupacao")
public class OcupacaoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codOcupacao;
	
	@Column(length = 100, nullable = false)
	private String nmModalidade;
	
	@Column(length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
    @Pattern(regexp = "[AI]")
    private String status = "A";

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = "A";
        }
    }
	
	public OcupacaoModel() {
		
	}

	public Long getCodOcupacao() {
		return codOcupacao;
	}

	public void setCodOcupacao(Long codOcupacao) {
		this.codOcupacao = codOcupacao;
	}

	public String getNm_Modalidade() {
		return nmModalidade;
	}

	public void setNm_Modalidade(String nm_Modalidade) {
		this.nmModalidade = nm_Modalidade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}

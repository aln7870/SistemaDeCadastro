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
@Table(name = "Modalidade")
public class ModalidadeModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codModalidade;
	
	@Column(length = 50, nullable = false)
	private String nm_Modalidade;
	
	@Column(length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
    @Pattern(regexp = "[AI]")
    private String status = "A";

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = "A";
        }
    }
	
	public ModalidadeModel() {
    }

	public Long getCodModalidade() {
		return codModalidade;
	}

	public void setCodModalidade(Long codModalidade) {
		this.codModalidade = codModalidade;
	}

	public String getNm_Modalidade() {
		return nm_Modalidade;
	}

	public void setNm_Modalidade(String nm_Modalidade) {
		this.nm_Modalidade = nm_Modalidade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

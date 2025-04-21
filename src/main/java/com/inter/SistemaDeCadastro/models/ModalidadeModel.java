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
	@Column(name = "CodModalidade")
	private Integer codModalidade;
	
	@Column(name = "Nm_Modalidade",length = 50, nullable = false)
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
	
	public ModalidadeModel() {
    }

	public Integer getCodModalidade() {
		return codModalidade;
	}

	public void setCodModalidade(Integer codModalidade) {
		this.codModalidade = codModalidade;
	}

	public String getNm_Modalidade() {
		return nome;
	}

	public void setNm_Modalidade(String nm_Modalidade) {
		this.nome = nm_Modalidade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

package com.inter.SistemaDeCadastro.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Pattern;

public class ParentescoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INT UNSIGNED AUTO_INCREMENT")
	private Long codParentesco;
	
	@Column(length = 50, nullable = false)
	private String nm_Aluno;
	
	@Column(length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
    @Pattern(regexp = "[AI]")
    private String status = "A";

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = "A";
        }
    }
    
    public ParentescoModel() {
    	
    }

	public Long getCodParentesco() {
		return codParentesco;
	}

	public void setCodParentesco(Long codParentesco) {
		this.codParentesco = codParentesco;
	}

	public String getNm_Aluno() {
		return nm_Aluno;
	}

	public void setNm_Aluno(String nm_Aluno) {
		this.nm_Aluno = nm_Aluno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    

}

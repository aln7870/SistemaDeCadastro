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
	@Column(name = "CodOcupacao")
	private Integer codOcupacao;
	
	@Column(name = "Nm_Ocupacao",length = 100, nullable = false)
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

	public Integer getCodOcupacao() {
		return codOcupacao;
	}

	public void setCodOcupacao(Integer codOcupacao) {
		this.codOcupacao = codOcupacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

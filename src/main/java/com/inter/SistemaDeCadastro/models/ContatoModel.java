package com.inter.SistemaDeCadastro.models;

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
@Table(name = "Contato")
public class ContatoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codContato;
	
	@Column(length = 80, nullable = false)
	private String responsavelEmergencial;
	
	@Column(length = 17, nullable = false)
	private String telefonePrincipal;
	
	@Column(length = 17, nullable = false)
	private String telefoneEmergencial;
	
	@Column(length = 150, nullable = false)
	private String email;
	
	@ManyToOne
    @JoinColumn(name = "codAluno", nullable = false)
	private AlunoModel aluno;
	
	@Column(length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
    @Pattern(regexp = "[AI]")
    private String status = "A";

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = "A";
        }
    }

	public Long getCodContato() {
		return codContato;
	}

	public void setCodContato(Long codContato) {
		this.codContato = codContato;
	}

	public String getResponsavelEmergencial() {
		return responsavelEmergencial;
	}

	public void setResponsavelEmergencial(String responsavelEmergencial) {
		this.responsavelEmergencial = responsavelEmergencial;
	}

	public String getTelefonePrincipal() {
		return telefonePrincipal;
	}

	public void setTelefonePrincipal(String telefonePrincipal) {
		this.telefonePrincipal = telefonePrincipal;
	}

	public String getTelefoneEmergencial() {
		return telefoneEmergencial;
	}

	public void setTelefoneEmergencial(String telefoneEmergencial) {
		this.telefoneEmergencial = telefoneEmergencial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AlunoModel getAluno() {
		return aluno;
	}

	public void setAluno(AlunoModel aluno) {
		this.aluno = aluno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

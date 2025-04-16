package com.inter.SistemaDeCadastro.models;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "Endereco")
public class EnderecoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INT UNSIGNED AUTO_INCREMENT")
	private Long codEndereco;
	
	@Column(length = 10, nullable = false)
	private String cep;
	
	@Column(length = 60, nullable = false)
	private String rua;
	
	@Column(length = 100, nullable = false)
	private String bairro;
	
	@Column(length = 70, nullable = false)
	private String cidade;
	
	@Column(nullable = false)
	private short numero;
	
	@Column(length = 40, nullable = false)
	private String resideCom;
	
	@Column(length = 40, nullable = false)
	private String outroResideCom;
	
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
	
	public EnderecoModel() {
		
	}

	public Long getCodEndereco() {
		return codEndereco;
	}

	public void setCodEndereco(Long codEndereco) {
		this.codEndereco = codEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public short getNumero() {
		return numero;
	}

	public void setNumero(short numero) {
		this.numero = numero;
	}

	public String getResideCom() {
		return resideCom;
	}

	public void setResideCom(String resideCom) {
		this.resideCom = resideCom;
	}

	public String getOutroResideCom() {
		return outroResideCom;
	}

	public void setOutroResideCom(String outroResideCom) {
		this.outroResideCom = outroResideCom;
	}
	
	public AlunoModel getCodAluno() {
		return aluno;
	}

	public void setCodAluno(AlunoModel aluno) {
		this.aluno = aluno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}

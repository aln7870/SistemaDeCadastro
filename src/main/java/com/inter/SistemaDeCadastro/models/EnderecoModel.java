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
@Table(name = "Endereco")
public class EnderecoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CodEndereco")
	private Integer codEndereco;
	
	@Column(name = "CEP",length = 10)
	private String cep;
	
	@Column(name = "Rua",length = 60, nullable = false)
	private String rua;
	
	@Column(name = "Bairro",length = 100, nullable = false)
	private String bairro;
	
	@Column(name = "Cidade",length = 70, nullable = false)
	private String cidade;
	
	@Column(name = "Numero", columnDefinition = "SMALLINT")
	private Short numero;
	
	@Column(name = "ResideCom",length = 40, nullable = false)
	private String resideCom;
	
	@Column(name = "OutroResideCom",length = 40)
	private String outroResideCom;
	
	@ManyToOne
    @JoinColumn(name = "CodAluno", nullable = false)
	private AlunoModel aluno;
	
	@Column(name = "Status",length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
    @Pattern(regexp = "[AI]")
    private String status = "A";

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = "A";
        }
    }

	public Integer getCodEndereco() {
		return codEndereco;
	}

	public void setCodEndereco(Integer codEndereco) {
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

	public Short getNumero() {
		return numero;
	}

	public void setNumero(Short numero) {
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

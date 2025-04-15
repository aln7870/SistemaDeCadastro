package com.inter.SistemaDeCadastro.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Saude")
public class SaudeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codSaude;

    @Size(max = 255)
    @Column(name = "DescricaoAlergia", columnDefinition = "TINYTEXT")
    private String descricaoAlergia;

    @Size(max = 255)
    @Column(name = "dascrecaoMedicacao", columnDefinition = "TINYTEXT")
    private String descricaoMedicacao;

    @Size(max = 255)
    @Column(name = "descricaoProblemaSaude", columnDefinition = "TINYTEXT")
    private String descricaoProblemaSaude;

    @Size(max = 255)
    @Column(name = "tipoDeficiencia", columnDefinition = "TINYTEXT")
    private String tipoDeficiencia;

    @Column(length = 1, nullable = false)
	private char status;
    
    
    public SaudeModel() {
    }

   
    public Long getCodSaude() {
        return codSaude;
    }

    public void setId(Long codSaude) {
        this.codSaude = codSaude;
    }

    public String getDescricaoAlergia() {
        return descricaoAlergia;
    }

    public void setDescricaoAlergia(String descricaoAlergia) {
        this.descricaoAlergia = descricaoAlergia;
    }

    public String getDescricaoMedicacao() {
        return descricaoMedicacao;
    }

    public void setDescricaoMedicacao(String descricaoMedicacao) {
        this.descricaoMedicacao = descricaoMedicacao;
    }

    public String getDescricaoProblemaSaude() {
        return descricaoProblemaSaude;
    }

    public void setDescricaoProblemaSaude(String descricaoProblemaSaude) {
        this.descricaoProblemaSaude = descricaoProblemaSaude;
    }

    public String getTipoDeficiencia() {
        return tipoDeficiencia;
    }

    public void setTipoDeficiencia(String tipoDeficiencia) {
        this.tipoDeficiencia = tipoDeficiencia;
    }

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

    

}
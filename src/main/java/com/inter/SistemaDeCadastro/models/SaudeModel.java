package com.inter.SistemaDeCadastro.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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
    @Column(name = "DescricaoMedicacao", columnDefinition = "TINYTEXT")
    private String descricaoMedicacao;

    @Size(max = 255)
    @Column(name = "DescricaoProblemaSaude", columnDefinition = "TINYTEXT")
    private String descricaoProblemaSaude;

    @Size(max = 255)
    @Column(name = "TipoDeficiencia", columnDefinition = "TINYTEXT")
    private String tipoDeficiencia;

    @Column(length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
    @Pattern(regexp = "[AI]")
    private String status = "A";

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = "A";
        }
    }

    public SaudeModel() {
    }

    public Long getCodSaude() {
        return codSaude;
    }

    public void setCodSaude(Long codSaude) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

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
@Table(name = "Escolaridade")
public class EscolaridadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codEscolaridade;

    @Column(name = "Nm_Escolaridade", length = 100, nullable = false)
    private String nome;

    @Column(length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
    @Pattern(regexp = "[AI]")
    private String status;

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = "A";
        }
    }

    public Long getCodEscolaridade() {
        return codEscolaridade;
    }

    public void setCodEscolaridade(Long codEscolaridade) {
        this.codEscolaridade = codEscolaridade;
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

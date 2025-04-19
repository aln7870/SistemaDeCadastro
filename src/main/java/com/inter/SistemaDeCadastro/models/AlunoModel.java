package com.inter.SistemaDeCadastro.models;


import java.sql.Date;
import java.time.LocalDateTime;

import com.inter.SistemaDeCadastro.models.enums.NacionalidadeAlunoEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Aluno")
public class AlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codAluno;

    @Column(name = "Nm_Aluno", length = 150, nullable = false)
    private String nome;

    @Column(updatable = false, name = "Dt_Nascimento")
    private Date dataNasc;

    @Column(name = "Sexo", length = 1, columnDefinition = "CHAR(1) DEFAULT NULL")
    @Pattern(regexp = "[MF]")
    private String sexo;

    @Column(name = "CPF", length = 14, nullable = false)
    private String cpf;


    @Column(name = "RG", length = 10, nullable = false)
    private String rg;

    @Column(name = "Nacionalidade", columnDefinition = "ENUM('BRASILEIRO', 'ESTRANGEIRO') DEFAULT 'BRASILEIRO'")
    @Enumerated(EnumType.STRING)
    private NacionalidadeAlunoEnum nacionalidade;

    @OneToOne()
    @JoinColumn(name = "codEscolaridade", referencedColumnName = "codEscolaridade")
    private EscolaridadeModel escolaridadeModel;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime dt_Cadastro;

    @Column(length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
    @Pattern(regexp = "[AI]")
    private String status = "A";

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = "A";
        }
    }

    public Long getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(Long codAluno) {
        this.codAluno = codAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public NacionalidadeAlunoEnum getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(NacionalidadeAlunoEnum nacionalidade) {
        this.nacionalidade = nacionalidade;
    }


    public LocalDateTime getDt_Cadastro() {
        return dt_Cadastro;
    }

    public void setDt_Cadastro(LocalDateTime dt_Cadastro) {
        this.dt_Cadastro = dt_Cadastro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EscolaridadeModel getEscolaridadeModel() {
        return escolaridadeModel;
    }

    public void setEscolaridadeModel(EscolaridadeModel escolaridadeModel) {
        this.escolaridadeModel = escolaridadeModel;
    }
}

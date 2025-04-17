package com.inter.SistemaDeCadastro.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "roles")
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Long idRole;

    @Column(length = 70)
    private String nome;

    //aceitar somente A OU I em status
    @Column(length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
    @Pattern(regexp = "[AI]")
    private String status = "A";

    // validando que por padrão status tera A
    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = "A";
        }
    }

    public enum values {
        ADMIN(1L),
        USER(2L);

        Long roleId;

        values(Long roleId) {
            this.roleId = roleId;
        }

        public long id() {
            return roleId;
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getNome() {
        return nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

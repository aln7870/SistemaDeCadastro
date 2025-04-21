package com.inter.SistemaDeCadastro.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.util.Set;

@Entity
@Table(name = "Role")
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodRole",columnDefinition = "INT UNSIGNED")
    private Integer idRole;

    @Column(name = "Nm_Role",length = 70)
    private String nome;

    //aceitar somente A OU I em status
    @Column(name = "Status",length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
    @Pattern(regexp = "[AI]")
    private String status = "A";

    @OneToMany(mappedBy = "role")
    private Set<UsuarioRoleModel> usuarioRoles;

    // validando que por padrão status tera A
    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = "A";
        }
    }

    public enum values {
        ADMIN(1),
        USER(2);

        Integer roleId;

        values(Integer roleId) {
            this.roleId = roleId;
        }

        public long id() {
            return roleId;
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
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

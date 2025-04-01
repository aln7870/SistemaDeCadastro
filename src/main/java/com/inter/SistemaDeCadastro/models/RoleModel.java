package com.inter.SistemaDeCadastro.models;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    private String nome;

    public enum values{
        ROLE_ADMIN(1L),
        ROLE_USER(2L);

        Long roleId;

        values(Long roleId) {
            this.roleId = roleId;
        }

        public long id(){
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
}

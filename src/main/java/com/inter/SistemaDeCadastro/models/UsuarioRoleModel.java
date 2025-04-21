package com.inter.SistemaDeCadastro.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "UsuarioRole")
public class UsuarioRoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodUsuarioRole", columnDefinition = "INT UNSIGNED")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CodUsuario", nullable = false)
    @JsonIgnore
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "CodRole", nullable = false)
    private RoleModel role;

    @Column(name = "Status",length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
    @Pattern(regexp = "[AI]")
    private String status;

    // validando que por padrão status tera A
    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = "A";
        }
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

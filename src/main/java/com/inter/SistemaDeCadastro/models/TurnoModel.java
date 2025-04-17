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
@Table(name = "Turno")
public class TurnoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codTurno;
	
	@Column(length = 50, nullable = false)
	private String nm_Turno;
	
	@Column(length = 1, columnDefinition = "CHAR(1) DEFAULT 'A'")
    @Pattern(regexp = "[AI]")
    private String status = "A";

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = "A";
        }
    }

	public Long getCodTurno() {
		return codTurno;
	}

	public void setCodTurno(Long codTurno) {
		this.codTurno = codTurno;
	}

	public String getNm_Turno() {
		return nm_Turno;
	}

	public void setNm_Turno(String nm_Turno) {
		this.nm_Turno = nm_Turno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

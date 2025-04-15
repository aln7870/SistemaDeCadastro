package com.inter.SistemaDeCadastro.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Turno")
public class TurnoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long codTurno;
	
	@Column(length = 50, nullable = false)
	private String nm_Turno;
	
	@Column(length = 1, nullable = false)
	private char status;
	
	public TurnoModel() {
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

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	
	
}

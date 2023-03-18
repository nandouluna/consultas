package com.doctores.consultas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "consultorio")
public class Consultorio {
    @Id
    @Column(name = "consultorio_id", nullable = false)
    private Long consultorioId;
    @Column(name = "numero")
    private int numero;
    @Column(name = "piso")
    private int piso;

    public Consultorio() {
    }

    public Consultorio(Long consultorioId, int numero, int piso) {
        this.consultorioId = consultorioId;
        this.numero = numero;
        this.piso = piso;
    }

    public Long getConsultorioId() {
        return consultorioId;
    }

    public void setConsultorioId(Long consultorioId) {
        this.consultorioId = consultorioId;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }
}


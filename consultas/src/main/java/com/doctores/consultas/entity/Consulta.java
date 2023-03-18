package com.doctores.consultas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "consulta")
public class Consulta {
    @Id
    @Column(name = "consulta_id", nullable = false)
    private Long consultaId;

    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name = "consultorio_id")
    private Long consultorioId;

    @Column(name = "hora")
    private Date hora;

    @Column(name = "nombrePaciente")
    private String nombrePaciente;

    public Consulta() {
    }

    public Consulta(Long doctorId, Long consultorioId, Date hora, String nombrePaciente) {
        this.doctorId = doctorId;
        this.consultorioId = consultorioId;
        this.hora = hora;
        this.nombrePaciente = nombrePaciente;
    }

    public Long getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(Long consultaId) {
        this.consultaId = consultaId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getConsultorioId() {
        return consultorioId;
    }

    public void setConsultorioId(Long consultorioId) {
        this.consultorioId = consultorioId;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }
}

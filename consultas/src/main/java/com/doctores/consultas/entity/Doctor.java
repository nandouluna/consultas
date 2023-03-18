package com.doctores.consultas.entity;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id", nullable = false)
    private Long doctorId;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Column(name = "apellido_materno")
    private String apeliidoMaterno;
    @Column(name = "especialidad")
    private String especialidad;


    public Doctor() {
    }

    public Doctor(Long doctorId, String nombre, String apellidoPaterno, String apeliidoMaterno, String especialidad) {
        this.doctorId = doctorId;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apeliidoMaterno = apeliidoMaterno;
        this.especialidad = especialidad;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApeliidoMaterno() {
        return apeliidoMaterno;
    }

    public void setApeliidoMaterno(String apeliidoMaterno) {
        this.apeliidoMaterno = apeliidoMaterno;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
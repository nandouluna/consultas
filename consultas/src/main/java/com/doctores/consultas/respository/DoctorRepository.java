package com.doctores.consultas.respository;

import com.doctores.consultas.entity.Consulta;
import com.doctores.consultas.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
package com.doctores.consultas.service;

import com.doctores.consultas.entity.Consulta;
import com.doctores.consultas.respository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    public Consulta findById(Long id) {
        return consultaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Consulta no encontrada"));
    }

    public Consulta save(Consulta consulta) {
        AtomicInteger contConsultasDoctores= new AtomicInteger();
        List<Consulta> consultas= consultaRepository.findAll();

        consultas.forEach(consulta1 -> {
            if((consulta.getHora().equals(consulta.getHora())) && consulta.getDoctorId()==consulta1.getDoctorId() ){
                try {
                    throw new Exception("No se puede agendar una consulta, el Dr tiene una cita programada");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if((consulta.getHora().equals(consulta.getHora())) && consulta.getConsultorioId()==consulta1.getDoctorId() ){
                try {
                    throw new Exception("No se puede agendar una consulta el consultorio esta ocupado");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(consulta.getNombrePaciente().equals(consulta1.getNombrePaciente())){
                int minutos = (int) ChronoUnit.MINUTES.between((Temporal) consulta.getHora(),(Temporal) consulta1.getHora());
                if(minutos<120){
                    try {
                        throw new Exception("No se puede agendar una consulta con el mismo paciente con menos de dos horas de diferencia");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            if(consulta.getHora().equals(consulta.getHora()) && consulta.getDoctorId()==consulta1.getDoctorId()){
                contConsultasDoctores.addAndGet(1);
            }
        });

        if(Integer.parseInt(contConsultasDoctores.toString())>8){
            try {
                throw new Exception("No se puede agendar una consulta, el Dr ya tiene mas de 8 consultas");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        return consultaRepository.save(consulta);
    }


    public void deleteById(Long id) {
        consultaRepository.deleteById(id);
    }
}

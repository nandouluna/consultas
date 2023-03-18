package com.doctores.consultas.controller;

import com.doctores.consultas.entity.Consulta;
import com.doctores.consultas.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("consultas", consultaService.findAll());
        return "index";
    }

    @GetMapping("/consultas/createnew")
    public String createPage() {
        return "create";
    }


    @PostMapping("/consultas/create")
    public String save(@ModelAttribute Consulta consulta) {
        consultaService.save(consulta);
        return "redirect:/";
    }

    @GetMapping("/consultas/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Consulta consulta = consultaService.findById(id);
        model.addAttribute("consulta", consulta);
        return "edit";
    }

    @PostMapping("/consultas/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Consulta consulta) {
        Consulta existingConsulta = consultaService.findById(id);
        existingConsulta.setConsultorioId(consulta.getConsultorioId());
        existingConsulta.setDoctorId(consulta.getDoctorId());
        existingConsulta.setHora(consulta.getHora());
        existingConsulta.setNombrePaciente(consulta.getNombrePaciente());
        consultaService.save(existingConsulta);
        return "redirect:/";
    }

    @GetMapping("/consultas/delete/{id}")
    public String delete(@PathVariable Long id) {
        consultaService.deleteById(id);
        return "redirect:/";
    }
}


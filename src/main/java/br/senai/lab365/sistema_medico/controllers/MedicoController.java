package br.senai.lab365.sistema_medico.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MedicoController {

    @PostMapping("/medicos")
    public void createMedico() {
        System.out.println("Criando médico...");
    }
}

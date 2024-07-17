package br.senai.lab365.sistema_medico.controllers;

import br.senai.lab365.sistema_medico.dtos.MedicoRequest;
import br.senai.lab365.sistema_medico.services.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    public void criaMedico(@RequestBody MedicoRequest request) {
        service.criaMedico(request);
    }
}

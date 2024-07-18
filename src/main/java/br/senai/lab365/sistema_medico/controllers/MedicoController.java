package br.senai.lab365.sistema_medico.controllers;

import br.senai.lab365.sistema_medico.dtos.MedicoGetRequest;
import br.senai.lab365.sistema_medico.dtos.MedicoRequest;
import br.senai.lab365.sistema_medico.dtos.MedicoResponse;
import br.senai.lab365.sistema_medico.dtos.MedicoResponsePagination;
import br.senai.lab365.sistema_medico.services.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> cadastra(
            @RequestBody MedicoRequest request) {
        service.cadastra(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Void> atualiza(
            @PathVariable Long id,
            @RequestBody MedicoRequest request) {
        service.atualiza(id, request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MedicoResponsePagination> lista(
            @RequestParam(value = "numeroPagina", defaultValue = "0", required = false) int numeroPagina,
            @RequestParam(value = "tamanhoPagina", defaultValue = "3", required = false) int tamanhoPagina
    ) {
        return ResponseEntity.ok(service.listaTodos(numeroPagina, tamanhoPagina));
    }
}

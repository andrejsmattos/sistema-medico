package br.senai.lab365.sistema_medico.dtos;

import br.senai.lab365.sistema_medico.enums.Especialidades;

import java.time.LocalDate;

public record MedicoRequest(String nome, String crm, LocalDate dataNascimento, Especialidades especialidade) {
}

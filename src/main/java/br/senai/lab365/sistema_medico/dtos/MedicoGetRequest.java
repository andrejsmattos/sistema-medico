package br.senai.lab365.sistema_medico.dtos;

import br.senai.lab365.sistema_medico.enums.Especialidades;

import java.time.LocalDate;

public class MedicoGetRequest {

    private String nome;
    private Especialidades especialidade;
    private LocalDate dataNascimento;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especialidades getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidades especialidade) {
        this.especialidade = especialidade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}

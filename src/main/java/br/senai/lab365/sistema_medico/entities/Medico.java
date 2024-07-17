package br.senai.lab365.sistema_medico.entities;

import br.senai.lab365.sistema_medico.enums.Especialidades;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String crm;
    private LocalDate dataNascimento;
    private Especialidades especialidade;

    public Medico() {
    }

    public Medico(Long id, String nome, String crm, LocalDate dataNascimento, Especialidades especialidade) {
        this.id = id;
        this.nome = nome;
        this.crm = crm;
        this.dataNascimento = dataNascimento;
        this.especialidade = especialidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Especialidades getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidades especialidade) {
        this.especialidade = especialidade;
    }
}

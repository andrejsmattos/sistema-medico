package br.senai.lab365.sistema_medico.services;

import br.senai.lab365.sistema_medico.dtos.MedicoRequest;
import br.senai.lab365.sistema_medico.entities.Medico;
import br.senai.lab365.sistema_medico.repositories.MedicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import static br.senai.lab365.sistema_medico.mappers.MedicoMapper.map;

@Service
public class MedicoService {

    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public void criaMedico(MedicoRequest request) {
        if (repository.existsByCrm(request.crm())) {
            throw new DuplicateKeyException("CRM já cadastrado");
        }

        repository.save(map(request));
    }

    public void atualizaMedico(Long id, MedicoRequest request) {
        Medico medico = repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        if (request.nome() != null) medico.setNome(request.nome());
        if (request.crm() != null) medico.setCrm(request.crm());
        if (request.dataNascimento() != null) medico.setDataNascimento(request.dataNascimento());
        if (request.especialidade() != null) medico.setEspecialidade(request.especialidade());

        repository.save(medico);
    }

}

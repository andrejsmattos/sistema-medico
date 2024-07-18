package br.senai.lab365.sistema_medico.services;

import br.senai.lab365.sistema_medico.dtos.MedicoGetRequest;
import br.senai.lab365.sistema_medico.dtos.MedicoRequest;
import br.senai.lab365.sistema_medico.dtos.MedicoResponse;
import br.senai.lab365.sistema_medico.dtos.MedicoResponsePagination;
import br.senai.lab365.sistema_medico.entities.Medico;
import br.senai.lab365.sistema_medico.repositories.MedicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static br.senai.lab365.sistema_medico.mappers.MedicoMapper.*;


@Service
public class MedicoService {

    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public void cadastra(MedicoRequest request) {
        if (repository.existsByCrm(request.crm())) {
            throw new DuplicateKeyException("CRM já cadastrado");
        }

        repository.save(map(request));
    }

    public void atualiza(Long id, MedicoRequest request) {
        Medico medico = repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        if (request.nome() != null) medico.setNome(request.nome());
        if (request.crm() != null) medico.setCrm(request.crm());
        if (request.dataNascimento() != null) medico.setDataNascimento(request.dataNascimento());
        if (request.especialidade() != null) medico.setEspecialidade(request.especialidade());

        repository.save(medico);
    }


    public MedicoResponsePagination listaTodos(int numeroPagina, int tamanhoPagina) {
        Pageable paginacao = PageRequest.of(numeroPagina, tamanhoPagina);
        Page<Medico> medicos = repository.findAll(paginacao);
        List<Medico> listaMedicos = medicos.getContent();
        List<MedicoGetRequest> conteudo = listaMedicos.stream().map(medico -> mapToDto(medico)).collect(Collectors.toList());

        MedicoResponsePagination medicoResponsePagination = new MedicoResponsePagination();
        medicoResponsePagination.setConteudo(conteudo);
        medicoResponsePagination.setTotalPaginas(medicos.getTotalPages());
        medicoResponsePagination.setTamanhoPagina(medicos.getSize());
        medicoResponsePagination.setPaginaAtual(medicos.getNumber());
        medicoResponsePagination.setUltima(medicos.isLast());

        return medicoResponsePagination;

    }


    public MedicoResponse busca(Long id) {
        Optional<Medico> medicoOptional = repository.findById(id);

        return mapEntityToResponse(medicoOptional.orElseThrow(EntityNotFoundException::new));
    }
}

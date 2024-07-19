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
        if (repository.existsByCrm(request.getCrm())) {
            throw new DuplicateKeyException("CRM já cadastrado: " + request.getCrm());
        }

        repository.save(map(request));
    }

    public void atualiza(Long id, MedicoRequest request) {
        Medico medico = repository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Médico não encontrado com o id: " + id)
                );

        if (request.getNome() != null) medico.setNome(request.getNome());
        if (request.getCrm() != null) medico.setCrm(request.getCrm());
        if (request.getDataNascimento() != null) medico.setDataNascimento(request.getDataNascimento());
        if (request.getEspecialidade() != null) medico.setEspecialidade(request.getEspecialidade());

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
        medicoResponsePagination.setTotalElementos((int) medicos.getTotalElements());
        medicoResponsePagination.setUltima(medicos.isLast());

        return medicoResponsePagination;

    }


    public MedicoResponse busca(Long id) {
        Optional<Medico> medicoOptional = repository.findById(id);

        return mapEntityToResponse(
                medicoOptional
                        .orElseThrow(
                                ()->new EntityNotFoundException("Médico não encontrado com o id: " + id)
                        ));
    }

    public void exclui(Long id) {

        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Médico não encontrado com o id: " + id);
        }
    }
}

package br.senai.lab365.sistema_medico.mappers;

import br.senai.lab365.sistema_medico.dtos.MedicoGetRequest;
import br.senai.lab365.sistema_medico.dtos.MedicoRequest;
import br.senai.lab365.sistema_medico.dtos.MedicoResponse;
import br.senai.lab365.sistema_medico.entities.Medico;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class MedicoMapper {

    public MedicoMapper() {
    }

    public static Medico map(MedicoRequest source) {
        if (source == null) return null;

        Medico target = new Medico();
        target.setNome(source.nome());
        target.setCrm(source.crm());
        target.setDataNascimento(source.dataNascimento());
        target.setEspecialidade(source.especialidade());
        return target;
    }


    public static MedicoGetRequest mapToDto(Medico medico) {
        MedicoGetRequest medicoGetRequest = new MedicoGetRequest();
        medicoGetRequest.setNome(medico.getNome());
        medicoGetRequest.setEspecialidade(medico.getEspecialidade());
        medicoGetRequest.setDataNascimento(medico.getDataNascimento());
        return medicoGetRequest;
    }

    public static MedicoResponse mapEntityToResponse(Medico source) {
        if (source == null) return null;

        MedicoResponse target = new MedicoResponse();
        target.setId(source.getId());
        target.setNome(source.getNome());
        target.setCrm(source.getCrm());
        target.setDataNascimento(source.getDataNascimento());
        target.setEspecialidade(source.getEspecialidade());
        return target;
    }

//    public static List<MedicoResponse> map(List<Medico> source) {
//        List<MedicoResponse> target = new ArrayList<>();
//
//        for (Medico medico : source) {
//            target.add(map(medico));
//        }
//
//        return target;
//    }
//
//    public static Page<MedicoResponse> map(Page<Medico> source) {
//        // return source.map(produto -> map(produto));
//        return source.map(MedicoMapper::map);
//    }
}

package br.senai.lab365.sistema_medico.mappers;

import br.senai.lab365.sistema_medico.dtos.MedicoRequest;
import br.senai.lab365.sistema_medico.entities.Medico;

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
}

package br.senai.lab365.sistema_medico.enums;
public enum Especialidades {
    CARDIOLOGIA("Cardiologia"),
    DERMATOLOGIA("Dermatologia"),
    GINECOLOGIA("Ginecologia"),
    NEUROLOGIA("Neurologia"),
    OFTALMOLOGIA("Oftalmologia"),
    ORTOPEDIA("Ortopedia"),
    PEDIATRIA("Pediatria"),
    PSIQUIATRIA("Psiquiatria"),
    UROLOGIA("Urologia"),
    GASTROENTEROLOGIA("Gastroenterologia"),
    ENDOCRINOLOGIA("Endocrinologia"),
    HEMATOLOGIA("Hematologia"),
    INFECTOLOGIA("Infectologia"),
    ONCOLOGIA("Oncologia"),
    REUMATOLOGIA("Reumatologia"),
    OTORRINOLARINGOLOGIA("Otorrinolaringologia"),
    PNEUMOLOGIA("Pneumologia"),
    NEFROLOGIA("Nefrologia"),
    CIRURGIA_GERAL("Cirurgia Geral"),
    CIRURGIA_PLASTICA("Cirurgia Plástica"),
    CIRURGIA_VASCULAR("Cirurgia Vascular"),
    ANESTESIOLOGIA("Anestesiologia"),
    RADIOLOGIA("Radiologia");

    private final String descricao;

    Especialidades(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

package br.jus.jfrn.minihigia.model.enums;

public enum InstrucaoPericiando {
    ANALFABETO("Analfabeto"),
    ANALFABETO_FUNCIONAL("Analfabeto Funcional"),
    FUNDAMENTAL("Fundamental"),
    ENSINO_MEDIO("Ensino Médio"),
    FUNDAMENTAL_INCOMPLETO("Fundamental Incompleto"),
    ENSINO_MEDIO_INCOMPLETO("Ensino Médio Incompleto"),
    CURSO_TECNICO_COM_FUNDAMENTAL("Ensino Técnico Com Ens. Fundamental"),
    CURSO_TECNICO_COM_MEDIO("Ensino Técnico Com Ens. Médio"),
    CURSO_TECNICO_COM_MEDIO_INCOMPLETO("Ensino Técnico Com Ens. Médio Incompleto"),
    SUPERIOR("Superior"),
    SUPERIOR_INCOMPLETO("Superior Incompleto"),
    SUPERIOR_COM_TECNICO("Superior Com Curso Técnico"),
    SUPERIOR_INCOMPLETO_COM_TECNICO("Superior Incompleto Com Curso Técnico"),
    SUPERIOR_COM_POS("Superior Com Pós-Graduação");

    private final String instrucao;

    private InstrucaoPericiando(String instrucao) {
        this.instrucao = instrucao;
    }

    public String getInstrucao() {
        return instrucao;
    }
}

package br.jus.jfrn.minihigia.model.enums;

public enum Status {
    ABERTA("Aberta"),
    RASCUNHO("Rascunho"),
    CONCLUIDA("Concluída");

    private final String status;

    private Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

package br.com.camtwo.spring.modal.enums;

public enum Status {
    EM_ANALISE(1, "Em Análise"),
    REALIZADO(2, "Análise Realizada"),
    APROVADO(3, "Análise aprovada"),
    INICIADO(4, "Iniciado"),
    PLANEJADO(5, "Planejado"),
    EM_ANDAMENTO(6, "Em Andamento"),
    ENCERRADO(7, "Encerrado"),
    CANCELADO(8, "Cancelado");

    private int id;
    private String descricao;

    Status(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    public static Status parse(int id) {
        Status status = null;
        for (Status item : Status.values()) {
            if (item.getId() == id) {
                status = item;
                break;
            }
        }
        return status;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

}

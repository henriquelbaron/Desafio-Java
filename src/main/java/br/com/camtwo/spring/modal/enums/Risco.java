package br.com.camtwo.spring.modal.enums;

public enum Risco {
    BAIXO(1, "Baixo Risco"),
    MEDIO(2, "Médio Risco"),
    ALTO(3, "Alto Risco");
    private String descricao;
    private Integer id;

    Risco(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    public static Risco parse(int id) {
        Risco risco = null;
        for (Risco item : Risco.values()) {
            if (item.getId() == id) {
                risco = item;
                break;
            }
        }
        return risco;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}

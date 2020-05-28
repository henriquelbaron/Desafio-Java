package br.com.camtwo.spring.modal;

import br.com.camtwo.spring.modal.enums.Risco;
import br.com.camtwo.spring.modal.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "projeto")
@NoArgsConstructor
@Getter
@Setter
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private LocalDate data_inicio;
    @NotBlank
    private LocalDate data_previsao_fim;
    @NotBlank
    private LocalDate data_fim;
    @NotBlank
    private String descricao;
    @Enumerated(EnumType.STRING)
    @NotBlank
    private Status status;
    @NotBlank
    private Double orcamento;
    @Enumerated(EnumType.STRING)
    @NotBlank
    private Risco risco;
    @OneToOne
    @JoinColumn(name = "idgerente",nullable = false)
    private Pessoa gerente;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "membros",
            joinColumns = @JoinColumn(name = "idprojeto",referencedColumnName= "id"),
            inverseJoinColumns = @JoinColumn(name = "idpessoa",referencedColumnName= "id"))
    private List<Pessoa> membros;

    public Projeto(Long id, String nome, LocalDate localDate, LocalDate date, LocalDate stringToLocalDate, String descricao,
                   Status parse, Double orcamento, Risco risco, Pessoa gerente) {
        this.id = id;
        this.nome = nome;
        this.data_fim = localDate;
        this.data_inicio = date;
        this.data_previsao_fim = stringToLocalDate;
        this.descricao = descricao;
        this.status = parse;
        this.risco = risco;
        this.gerente = gerente;
        this.orcamento = orcamento;
    }

}

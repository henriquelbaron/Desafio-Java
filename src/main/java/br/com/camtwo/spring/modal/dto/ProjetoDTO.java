package br.com.camtwo.spring.modal.dto;

import br.com.camtwo.spring.modal.Pessoa;
import br.com.camtwo.spring.modal.Projeto;
import br.com.camtwo.spring.modal.enums.Risco;
import br.com.camtwo.spring.modal.enums.Status;
import br.com.camtwo.spring.util.UtilsDate;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;


@Getter
@Setter
public class ProjetoDTO {

    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String data_inicio;
    @NotBlank
    private String data_previsao_fim;
    @NotBlank
    private String data_fim;
    @NotBlank
    private String descricao;
    @NotBlank
    private Integer status;
    @NotBlank
    private Double orcamento;
    @NotBlank
    private Integer risco;
    @NotBlank
    private Pessoa gerente;
    @NotBlank
    private List<Pessoa> membros;

    public Projeto dtoToObjetc() {
        Projeto pessoa = new Projeto();
        pessoa.setId(id);
        pessoa.setNome(nome);
        pessoa.setMembros(membros);
        pessoa.setGerente(gerente);
        pessoa.setOrcamento(orcamento);
        pessoa.setDescricao(descricao);
        pessoa.setRisco(Risco.parse(risco));
        pessoa.setStatus(Status.parse(status));
        pessoa.setData_fim(UtilsDate.stringToLocalDate(data_fim));
        pessoa.setData_inicio(UtilsDate.stringToLocalDate(data_inicio));
        pessoa.setData_previsao_fim(UtilsDate.stringToLocalDate(data_previsao_fim));
        return pessoa;
    }
}

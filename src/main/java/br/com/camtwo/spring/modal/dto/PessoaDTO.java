package br.com.camtwo.spring.modal.dto;

import br.com.camtwo.spring.modal.Pessoa;
import br.com.camtwo.spring.util.UtilsDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDTO {
    private Long id;
    private String nome;
    private String datanascimento;
    private String cpf;
    private boolean funcionario;

    public Pessoa dtoToObject() {
        return new Pessoa(id, nome, UtilsDate.stringToLocalDate(datanascimento), cpf, funcionario);
    }
}

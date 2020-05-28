package br.com.camtwo.spring.modal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "pessoa")
@NoArgsConstructor
@Getter
@Setter
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate datanascimento;
    private String cpf;
    private boolean funcionario;
    @ManyToMany(mappedBy = "membros")
    private List<Projeto> projetos= new ArrayList<>();

    public Pessoa(Long id, String nome, LocalDate datanascimento, String cpf, boolean funcionario) {
        this.id = id;
        this.nome = nome;
        this.datanascimento = datanascimento;
        this.cpf = cpf;
        this.funcionario = funcionario;
    }

    public void addProjetos(Projeto projeto){
        this.projetos.add(projeto);
        projeto.getMembros().add(this);
    }
    public void removeProjetos(Projeto projeto) {
        this.projetos.remove(projeto);
        projeto.getMembros().remove(this);
    }

}

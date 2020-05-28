package br.com.camtwo.spring.service;

import br.com.camtwo.spring.exceptions.NaoPodeSerExcluido;
import br.com.camtwo.spring.exceptions.PessoaNaoEFuncionario;
import br.com.camtwo.spring.modal.Pessoa;
import br.com.camtwo.spring.modal.Projeto;
import br.com.camtwo.spring.modal.enums.Status;
import br.com.camtwo.spring.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private PessoaService pessoaService;

    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }


    public Projeto findById(Long id) {
        return projetoRepository.findById(id).orElse(null);
    }

    public Projeto save(Projeto projeto) {
        if (projeto.getMembros()!=null && !projeto.getMembros().isEmpty()) {
            for (int i = 0; i < projeto.getMembros().size(); i++) {
                Pessoa pessoa = projeto.getMembros().get(i);
                projeto.getMembros().remove(i);
                pessoa = pessoaService.findById(pessoa.getId());
                if (!pessoa.isFuncionario()) {
                    throw new PessoaNaoEFuncionario(pessoa.getNome() + " Não é funcionario");
                }
                pessoa.addProjetos(projeto);
                projeto.getMembros().set(i, pessoa);
            }
        }
        return projetoRepository.saveAndFlush(projeto);
    }

    public Projeto update(Projeto projeto) {
        return save(projeto);
    }

    public void delete(Projeto projeto) {
        projetoRepository.delete(projeto);
    }

    public void deleteById(Long id) {
        Projeto projeto = findById(id);
        if (projeto.getStatus().equals(Status.CANCELADO) ||
                projeto.getStatus().equals(Status.EM_ANDAMENTO) ||
                projeto.getStatus().equals(Status.INICIADO)) {
            throw new NaoPodeSerExcluido("Projetos iniciado, em andamento ou encerrado não pode mais ser excluído!");
        }
        projetoRepository.delete(projeto);
    }

    public Boolean ifExists(Long id) {
        return projetoRepository.existsById(id);
    }

}

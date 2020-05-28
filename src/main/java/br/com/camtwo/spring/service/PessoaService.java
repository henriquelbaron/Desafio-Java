package br.com.camtwo.spring.service;

import br.com.camtwo.spring.modal.Pessoa;
import br.com.camtwo.spring.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }


    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa update(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void delete(Pessoa pessoa) {
        pessoaRepository.delete(pessoa);
    }

    public void deleteById(Long id) {
        Pessoa pessoa = findById(id);
        pessoaRepository.delete(pessoa);
    }

    public Boolean ifExists(Long id){
        return pessoaRepository.existsById(id);
    }

}

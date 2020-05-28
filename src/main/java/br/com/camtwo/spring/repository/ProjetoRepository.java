package br.com.camtwo.spring.repository;

import br.com.camtwo.spring.modal.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {


}

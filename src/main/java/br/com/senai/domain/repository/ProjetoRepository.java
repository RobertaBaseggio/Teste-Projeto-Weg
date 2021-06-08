package br.com.senai.domain.repository;

import br.com.senai.domain.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto,Long> {

    List<Projeto> findByNome(String nome);
    List<Projeto> findByStatus(String status);
    List<Projeto> findBySecao(String secao);
    List<Projeto> findByNomeContaining(String nome);
}

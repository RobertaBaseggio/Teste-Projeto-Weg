package br.com.senai.domain.service;

import br.com.senai.api.assembler.ProjetoAssembler;
import br.com.senai.api.model.ProjetoModel;
import br.com.senai.domain.exception.NegocioException;
import br.com.senai.domain.model.Projeto;
import br.com.senai.domain.repository.ProjetoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProjetoService {

    private ProjetoRepository projetoRepository;
    private ProjetoAssembler projetoAssembler;




    public Projeto buscar(Long projetoId){
        return projetoRepository.findById(projetoId)
                .orElseThrow(()->new NegocioException("Projeto não encontrado."));
    }

    public ResponseEntity<ProjetoModel> buscarProjeto(Long projetoId) {
        return projetoRepository.findById(projetoId).map(entrega -> {

            return ResponseEntity.ok(projetoAssembler.toModel(entrega));
        })
                .orElseThrow(()-> new NegocioException("Projeto não encontrado."));

    }

    public List<ProjetoModel> listar(){

        boolean ListValidation = projetoRepository.findAll().isEmpty();

        if (ListValidation) {
            throw new NegocioException("Não existe nenhuma projeto cadastrado.");
        }

        return projetoAssembler.toCollectionModel(projetoRepository.findAll());
    }

    public List<ProjetoModel> listarPorNome(String nome){

        boolean nomeValidation = projetoRepository.findByNome(nome).isEmpty();

        if (nomeValidation) {
            throw new NegocioException("Não existe nenhum projeto cadastrado com este nome.");
        }

        return projetoAssembler.toCollectionModel(projetoRepository.findByNome(nome));
    }


    public List<ProjetoModel> listarNomeContaining(String nomeContaining){

        boolean containingValidation = projetoRepository.findByNomeContaining(nomeContaining).isEmpty();

        if (containingValidation) {
            throw new NegocioException("Não encontrado.");
        }

        return projetoAssembler.toCollectionModel(projetoRepository.findByNomeContaining(nomeContaining));
    }


}

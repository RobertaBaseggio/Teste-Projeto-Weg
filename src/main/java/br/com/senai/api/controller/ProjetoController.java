package br.com.senai.api.controller;

import br.com.senai.domain.model.Projeto;
import br.com.senai.domain.repository.ProjetoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    private ProjetoRepository projetoRepository;

    @GetMapping
    public List<Projeto> listar(){

    return projetoRepository.findAll();

    }
    @GetMapping("/nome/{projetoNome}")
    public List<Projeto> listarPorNome(@PathVariable String projetoNome){
        return projetoRepository.findByNome(projetoNome);
    }

    @GetMapping("/nome/containing/{projetoContaining}")
    public List<Projeto> listarNomeContaining(@PathVariable String projetoContaining){
        return projetoRepository.findByNomeContaining(projetoContaining);
    }

    @GetMapping("/status/{projetoStatus}")
    public List<Projeto> listarPorStatus(@PathVariable String projetoStatus){
        return projetoRepository.findByStatus(projetoStatus);
    }

    @GetMapping("/seção/{projetoSecao}")
    public List<Projeto> listarPorSecao(@PathVariable String projetoSecao){
        return projetoRepository.findBySecao(projetoSecao);
    }

    @GetMapping("/{projetoId}")
    public ResponseEntity<Projeto> buscar(@PathVariable Long projetoId){

        return projetoRepository.findById(projetoId)
                .map(projeto -> ResponseEntity.ok(projeto))
                .orElse(ResponseEntity.notFound().build());

    }

}

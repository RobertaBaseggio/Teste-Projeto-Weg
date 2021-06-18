package br.com.senai.api.controller;

import br.com.senai.api.model.ProjetoModel;
import br.com.senai.domain.model.Projeto;
import br.com.senai.domain.repository.ProjetoRepository;
import br.com.senai.domain.service.ProjetoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    private ProjetoRepository projetoRepository;
    private ProjetoService projetoService;

    @GetMapping
    public List<ProjetoModel> listar(){

        return projetoService.listar();

    }
    @GetMapping("/nome/{projetoNome}")
    public List<ProjetoModel> listarPorNome(@PathVariable String projetoNome){
        return projetoService.listarPorNome(projetoNome);
    }

    @GetMapping("/nome/containing/{projetoContaining}")
    public List<ProjetoModel> listarNomeContaining(@PathVariable String projetoContaining){
        return projetoService.listarNomeContaining(projetoContaining);
    }

    @GetMapping("/status/{projetoStatus}")
    public List<ProjetoModel> listarPorStatus(@PathVariable String projetoStatus){
        return projetoService.listarPorStatus(projetoStatus);
    }


    @GetMapping("/seção/{projetoSecao}")
    public List<ProjetoModel> listarPorSecao(@PathVariable String projetoSecao){
        return projetoService.listarPorSecao(projetoSecao);
    }

    @GetMapping("/{projetoId}")
    public ResponseEntity<ProjetoModel> buscar(@PathVariable Long projetoId){

        return projetoService.buscarProjeto(projetoId);

    }

}

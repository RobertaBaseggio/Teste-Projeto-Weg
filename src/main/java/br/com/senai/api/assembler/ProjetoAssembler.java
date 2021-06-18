package br.com.senai.api.assembler;

import br.com.senai.api.model.ProjetoModel;
import br.com.senai.api.model.input.ProjetoInput;
import br.com.senai.domain.model.Projeto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProjetoAssembler {

    private ModelMapper modelMapper;

    public ProjetoModel toModel(Projeto projeto){
        return modelMapper.map(projeto, ProjetoModel.class);
    }

    public List<ProjetoModel> toCollectionModel(List<Projeto> projetos){
        return projetos.stream().map(this::toModel).collect(Collectors.toList());
    }

    public  Projeto toEntity(ProjetoInput projetoInput){
        return modelMapper.map(projetoInput, Projeto.class);
    }

    public  Projeto toEntity(ProjetoModel projetoModel){
        return modelMapper.map(projetoModel, Projeto.class);
    }
}

package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProjetoModel {

    long id;
    String secao;
    String nome;
    String descricao;
    String status;
    String dataInicio;
    String dataFim;
    String horasApontadas;
    String horasTotal;
}

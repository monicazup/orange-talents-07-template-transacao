package com.zupedu.monica.transacoesot7.kafka;

import com.zupedu.monica.transacoesot7.transacao.Estabelecimento;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;

public class EstabelecimentoDto {
    private String nome;

    @NotBlank
    private String cidade;

    @NotBlank
    private String endereco;

    public EstabelecimentoDto(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }


    @Deprecated
    public EstabelecimentoDto() {
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento paraEstabelecimento() {
        return new Estabelecimento(nome, cidade, endereco);
    }
}

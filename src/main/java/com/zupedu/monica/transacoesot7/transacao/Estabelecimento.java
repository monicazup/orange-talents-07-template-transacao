package com.zupedu.monica.transacoesot7.transacao;

import com.zupedu.monica.transacoesot7.transacao.dto.EstabelecimentoResponse;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Estabelecimento {

    @NotBlank
    @Column(name = "estabelecimento_nome")
    private String nome;

    @NotBlank
    @Column(name = "estabelecimento_cidade")
    private String cidade;

    @NotBlank
    @Column(name = "estabelecimento_endereco")
    private String endereco;

    public Estabelecimento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
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

    @Deprecated
    public Estabelecimento() {
    }
    public EstabelecimentoResponse paraResponse() {
        return new EstabelecimentoResponse(this.nome, this.cidade, this.endereco);
    }
}

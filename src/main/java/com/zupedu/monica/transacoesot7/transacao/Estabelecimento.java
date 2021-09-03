package com.zupedu.monica.transacoesot7.transacao;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @Deprecated
    public Estabelecimento() {
    }
}

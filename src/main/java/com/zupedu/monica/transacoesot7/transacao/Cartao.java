package com.zupedu.monica.transacoesot7.transacao;

import com.zupedu.monica.transacoesot7.transacao.dto.CartaoResponse;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Cartao {
    @Column(name = "cartao_id")
    private String idCartao;
    @Column(name = "cartao_email")
    private String email;

    public Cartao(String idCartao, String email) {
        this.idCartao = idCartao;
        this.email = email;
    }
    @Deprecated
    public Cartao(){ }

    public String getIdCartao() {
        return idCartao;
    }

    public String getEmail() {
        return email;
    }

    public CartaoResponse paraResponse(){
        return new CartaoResponse(this.idCartao, this.email);
    }
}

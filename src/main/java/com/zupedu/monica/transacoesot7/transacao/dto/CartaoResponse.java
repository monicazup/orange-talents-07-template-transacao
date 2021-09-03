package com.zupedu.monica.transacoesot7.transacao.dto;

import com.zupedu.monica.transacoesot7.transacao.Cartao;

public class CartaoResponse {
    private String idCartao;
    private String email;

    public String getIdCartao() {
        return idCartao;
    }

    public String getEmail() {
        return email;
    }

    public CartaoResponse(String idCartao, String email) {
        this.idCartao = idCartao;
        this.email = email;
    }

    public CartaoResponse(Cartao cartao) {
        this.idCartao = cartao.getIdCartao();
        this.email = cartao.getEmail();
    }
}

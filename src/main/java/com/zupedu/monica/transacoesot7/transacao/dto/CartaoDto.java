package com.zupedu.monica.transacoesot7.transacao.dto;

import com.zupedu.monica.transacoesot7.transacao.Cartao;

public class CartaoDto {


    private String id;
    private String email;

    public CartaoDto(String id, String email) {
        this.id = id;
        this.email = email;
    }
    @Deprecated
    public CartaoDto(){

    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao paraCartao() {
        return new Cartao(id, email);
    }
}

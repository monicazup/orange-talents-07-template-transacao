package com.zupedu.monica.transacoesot7.transacao;

import com.zupedu.monica.transacoesot7.transacao.dto.TransacaoResponse;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id @NotNull
    private String id;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    @Embedded
    private Estabelecimento estabelecimento;

    @NotNull
    @Embedded
    private Cartao cartao;

    @NotNull
    private LocalDateTime efetivadaEm;

    public Transacao(String id,
                     BigDecimal valor,
                     Estabelecimento estabelecimento,
                     Cartao cartao,
                     LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    @Deprecated
    public Transacao() {
    }

    public TransacaoResponse paraResponse() {
        return new TransacaoResponse(this.id, this.valor, this.estabelecimento.paraResponse(), this.cartao.paraResponse(), this.efetivadaEm);
    }
}

package com.zupedu.monica.transacoesot7.kafka;

import com.zupedu.monica.transacoesot7.transacao.Transacao;
import com.zupedu.monica.transacoesot7.transacao.dto.CartaoDto;
import com.zupedu.monica.transacoesot7.transacao.dto.EstabelecimentoDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoEvento {

    private String id;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    private EstabelecimentoDto estabelecimento;

    @NotNull
    private CartaoDto cartao;

    @NotNull
    private LocalDateTime efetivadaEm;

    public TransacaoEvento(String id, BigDecimal valor, EstabelecimentoDto estabelecimento, CartaoDto cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }
    @Deprecated
    public TransacaoEvento(){}

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoDto getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoDto getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao paraTransacao() {
        return new Transacao(this.id, this.valor, this.estabelecimento.paraEstabelecimento(), this.cartao.paraCartao(), this.efetivadaEm);
    }
}

package com.zupedu.monica.transacoesot7.transacao;

import com.zupedu.monica.transacoesot7.kafka.TransacaoEvento;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    @Autowired
    private TransacaoRepository repository;

    Logger logger = LoggerFactory.getLogger(ListenerDeTransacao.class);

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoEvento eventoDeTransacao) {
        System.out.println(eventoDeTransacao);
        Transacao transacao = eventoDeTransacao.paraTransacao();
        logger.info("Salvando transacao do cartao: " + transacao.getCartao());
        repository.save(transacao);
    }

}

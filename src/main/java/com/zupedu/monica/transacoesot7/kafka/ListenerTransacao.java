package com.zupedu.monica.transacoesot7.kafka;

import com.zupedu.monica.transacoesot7.transacao.Transacao;
import com.zupedu.monica.transacoesot7.transacao.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerTransacao {

    @Autowired
    private TransacaoRepository repository;

    Logger logger = LoggerFactory.getLogger(ListenerTransacao.class);

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoEvento eventoDeTransacao) {
        System.out.println(eventoDeTransacao);
        Transacao transacao = eventoDeTransacao.paraTransacao();
        logger.info("Salvando transacao do cartao: " + transacao.getCartao());
        repository.save(transacao);
    }

}

package com.zupedu.monica.transacoesot7.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    TransacaoRepository repository;

    @GetMapping("/{id}/listar")
    public ResponseEntity<List<Transacao>> listarDezUltimas(@PathVariable("id") String idCartao) {

        List<Transacao> listaUltimasDezTransacoes = repository.findFirst10ByCartaoOrderByEfetivadaEmDesc(idCartao);


        if(listaUltimasDezTransacoes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(listaUltimasDezTransacoes);
    }
}

package com.zupedu.monica.transacoesot7.transacao;

import com.zupedu.monica.transacoesot7.transacao.dto.TransacaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    TransacaoRepository repository;

    @GetMapping("/{id}/listar")
    public ResponseEntity<List<TransacaoResponse>> listarDezUltimas(@PathVariable("id") String idCartao) {
        System.out.println("23");
        List<Transacao> listaUltimasDezTransacoes = repository.findFirst10ByCartaoIdOrderByEfetivadaEmDesc(idCartao);

        if(listaUltimasDezTransacoes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<TransacaoResponse> listaResponse = listaUltimasDezTransacoes
                .stream()
                .map(transacao -> transacao.paraResponse())
                .collect(Collectors.toList());


        return ResponseEntity.ok().body(listaResponse);
    }
}

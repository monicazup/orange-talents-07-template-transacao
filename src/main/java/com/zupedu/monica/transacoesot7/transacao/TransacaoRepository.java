package com.zupedu.monica.transacoesot7.transacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String> {
    @Query(value = "SELECT * from transacao t where t.cartao_id = :idCartao order by t.efetivada_em desc limit 10", nativeQuery = true)
    List<Transacao> findFirst10ByCartaoIdOrderByEfetivadaEmDesc(String idCartao);

}

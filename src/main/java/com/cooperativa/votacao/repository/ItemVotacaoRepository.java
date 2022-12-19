package com.cooperativa.votacao.repository;

import com.cooperativa.votacao.model.BaseId;
import com.cooperativa.votacao.model.ItemVotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVotacaoRepository extends JpaRepository<ItemVotacao, BaseId> {
}

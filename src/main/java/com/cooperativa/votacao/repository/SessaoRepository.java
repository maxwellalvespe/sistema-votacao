package com.cooperativa.votacao.repository;

import com.cooperativa.votacao.model.BaseId;
import com.cooperativa.votacao.model.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, BaseId> {
}

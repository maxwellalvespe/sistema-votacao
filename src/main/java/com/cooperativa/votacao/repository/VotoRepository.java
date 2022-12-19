package com.cooperativa.votacao.repository;

import com.cooperativa.votacao.model.BaseId;
import com.cooperativa.votacao.model.Voto;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<Voto, BaseId> {
}

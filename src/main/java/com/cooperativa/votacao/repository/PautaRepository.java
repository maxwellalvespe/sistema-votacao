package com.cooperativa.votacao.repository;

import com.cooperativa.votacao.model.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PautaRepository extends JpaRepository<Pauta,Long> {
    Optional<Pauta> findBySessao(Integer idSessao);
}

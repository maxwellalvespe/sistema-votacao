package com.cooperativa.votacao.service;

import com.cooperativa.votacao.model.Pauta;
import com.cooperativa.votacao.resource.dto.PautaDTOResponse;
public interface PautaService {

    PautaDTOResponse cadastrarPauta(Pauta pauta);

    void iniciarVotacao(Integer idSessao);

    void finalizarSessao(Pauta pauta);
}

package com.cooperativa.votacao.service.impl;

import com.cooperativa.votacao.config.exception.UsuarioJaCadastradoNessaSessao;
import com.cooperativa.votacao.model.Pauta;
import com.cooperativa.votacao.repository.PautaRepository;
import com.cooperativa.votacao.resource.dto.PautaDTOResponse;
import com.cooperativa.votacao.service.PautaService;
import com.cooperativa.votacao.service.TaskVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
@Slf4j
public class PautaServiceImpl implements PautaService {

    private final PautaRepository repository;

    @Override
    public PautaDTOResponse cadastrarPauta(Pauta pauta) throws UsuarioJaCadastradoNessaSessao {

        if (analisarDuplicidadeDeUsuarioParaPauta(pauta)) {
            throw new UsuarioJaCadastradoNessaSessao();
        }
        var response = repository.save(pauta);
        return PautaDTOResponse.of(response);
    }

    @Override
    public void iniciarVotacao(Integer idSessao) {
        var pauta = repository.findBySessao(idSessao).orElseThrow();
        pauta.setStatusSessao(true);
        log.info("Pauta obtida :: {}", pauta);
        repository.save(pauta);
        finalizarSessao(pauta);
    }

    @Override
    public void finalizarSessao(Pauta task) {
        TaskVotacao votacao = new TaskVotacao(this);
        votacao.schenduler(task);
        repository.save(task);
    }

    private boolean analisarDuplicidadeDeUsuarioParaPauta(Pauta pauta) {
        if (nonNull(pauta.getSessao())) {
            return repository.findBySessao(pauta.getSessao()).filter(us -> us.getIdUsuario().equals(pauta.getIdUsuario())).isPresent();
        }
        return false;
    }


}

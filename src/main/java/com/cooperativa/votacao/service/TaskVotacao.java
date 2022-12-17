package com.cooperativa.votacao.service;

import com.cooperativa.votacao.model.Pauta;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;

@RequiredArgsConstructor
@Data
@Slf4j
public class TaskVotacao {

    private final PautaService service;
    private boolean isValid;

    public void schenduler(Pauta pauta) {

        EnqueteRunnable enqueteRunnable = EnqueteRunnable.of(pauta,service);


    }
}

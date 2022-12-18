package com.cooperativa.votacao.service;

import com.cooperativa.votacao.model.Pauta;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Data
public class EnqueteRunnable implements Runnable {

    private static final Integer TIME = 5;
    private static EnqueteRunnable instance;
    private Pauta pauta;

    private int tempo;
    private final PautaService service;
    private Thread t;

    public static EnqueteRunnable of(Pauta pauta, PautaService service) {
        if (instance == null) {
            instance = new EnqueteRunnable(pauta, service);
        }
        if(pauta.getSessao() != instance.getPauta().getSessao() ){
            instance = new EnqueteRunnable(pauta, service);
        }
        return instance;
    }

    private EnqueteRunnable(Pauta pauta, PautaService service) {
        this.pauta = pauta;
        this.service = service;
        this.tempo = 60;
        if (t == null) {
            t = new Thread(this);
            t.start();

        }
    }

    @Override
    public void run() {
        var inicio = System.currentTimeMillis();
        log.info("executando cronometro da enquete.. {}", inicio);

        while (tempo > 0) {
            try {
                Thread.sleep(TIME*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            tempo = 0;
        }

        if (tempo == 0) {
            pauta.setStatusSessao(false);
            service.finalizarSessao(pauta);
            log.info("Finalizando processamento : tempo de execução {} ms", System.currentTimeMillis() - inicio);
            t.interrupt();

        }

    }
}

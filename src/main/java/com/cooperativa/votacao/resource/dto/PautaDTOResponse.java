package com.cooperativa.votacao.resource.dto;

import com.cooperativa.votacao.model.Pauta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.datetime.standard.DateTimeFormatterFactory;

import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
public class PautaDTOResponse {

    private Long id;
    private String horario;


    public static PautaDTOResponse of(Pauta pauta) {
        return new PautaDTOResponse(pauta.getId(), pauta.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }
}

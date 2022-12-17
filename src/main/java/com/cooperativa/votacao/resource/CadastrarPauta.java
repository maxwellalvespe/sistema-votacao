package com.cooperativa.votacao.resource;

import com.cooperativa.votacao.model.Pauta;
import com.cooperativa.votacao.resource.dto.PautaDTOResponse;
import com.cooperativa.votacao.service.PautaService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pautas")
@RequiredArgsConstructor
@Slf4j
public class CadastrarPauta {

    private  final PautaService pautaService;

    @PostMapping
    public ResponseEntity<PautaDTOResponse> cadastrarPauta(@RequestBody Pauta pauta){
        return new ResponseEntity<>(pautaService.cadastrarPauta(pauta),HttpStatus.CREATED);
    }

    @PutMapping("{sessao}/iniciar")
    public ResponseEntity<String> iniciarSessao(@PathVariable Integer sessao){
        pautaService.iniciarVotacao(sessao);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body("Sessão aberta: o tempo default de votação é de 1 minuto.");
    }


}

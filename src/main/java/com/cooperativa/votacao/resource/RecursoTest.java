package com.cooperativa.votacao.resource;

import com.cooperativa.votacao.model.ItemVotacao;
import com.cooperativa.votacao.model.Sessao;
import com.cooperativa.votacao.model.Usuario;
import com.cooperativa.votacao.model.Voto;
import com.cooperativa.votacao.model.enums.OpcoesDeVoto;
import com.cooperativa.votacao.repository.ItemVotacaoRepository;
import com.cooperativa.votacao.repository.SessaoRepository;
import com.cooperativa.votacao.repository.UsuarioRepository;
import com.cooperativa.votacao.repository.VotoRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teste")
@Slf4j
public class RecursoTest {


    @Autowired
    UsuarioRepository usuarioRepository;


    @Autowired
    VotoRepository votoRepository;

    @Autowired
    SessaoRepository sessaoRepository;

    @Autowired
    ItemVotacaoRepository itemVotacaoRepository;


    @GetMapping
    public void execute(){
        Usuario us1 = new Usuario();
        Usuario us2 = new Usuario();

        Voto v1 = new Voto();
        Voto v2 = new Voto();

        //criação do usuario
        us1.setCpf("123");
        us1.setNome("max");

        us2.setCpf("321");
        us2.setNome("bia");

        v1.setUsuario(us1);
        v1.setVoto(OpcoesDeVoto.SIM);
        v2.setUsuario(us2);
        v2.setVoto(OpcoesDeVoto.NAO);

        Usuario save = usuarioRepository.save(us1);
        log.info("usuario salvo : {}", save.getNome());

        Usuario save2 = usuarioRepository.save(us2);
        log.info("usuario salvo : {}", save2.getNome());

        Voto voto = votoRepository.save(v1);
        log.info("voto registrado  : {}", String.format("Voto %s  do usuario %s",voto.getVoto(),voto.getUsuario().getNome()));

        Voto voto2 = votoRepository.save(v2);
        log.info("voto registrado  : {}", String.format("Voto %s  do usuario %s",voto2.getVoto(),voto2.getUsuario().getNome()));



    }


    @GetMapping("/list")
    public ResponseEntity<List<Voto>> findall(){
        List<Voto> retorno = votoRepository.findAll();
        return ResponseEntity.of(Optional.of(retorno));
    }

    @GetMapping("/sessao")
    public ResponseEntity<List<Sessao>> sessao(){
        Sessao s = new Sessao();
        s.setStatus(true);
        s.setVotos(votoRepository.findAll());



        ItemVotacao itemVotacao =  new ItemVotacao();
        itemVotacao.setDescricao("Priorizar pintura do condominio");

        itemVotacaoRepository.save(itemVotacao);
        s.setItemVotacao(itemVotacao);



        sessaoRepository.save(s);
        return  ResponseEntity.of(Optional.of(sessaoRepository.findAll()));

    }
}

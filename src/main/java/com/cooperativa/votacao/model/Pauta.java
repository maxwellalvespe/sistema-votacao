package com.cooperativa.votacao.model;

import com.cooperativa.votacao.model.enums.Voto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer sessao;
    private String assunto;
    private boolean statusSessao;
    private Long idUsuario;
    @Enumerated(EnumType.STRING)
    private Voto voto;

    private final LocalDateTime dataCriacao =  LocalDateTime.now();


}

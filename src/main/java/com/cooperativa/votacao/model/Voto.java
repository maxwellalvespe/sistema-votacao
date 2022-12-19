package com.cooperativa.votacao.model;

import com.cooperativa.votacao.model.enums.OpcoesDeVoto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Voto extends BaseId {


    @Enumerated(EnumType.STRING)
    private OpcoesDeVoto voto;

    @OneToOne
    private Usuario usuario;

    private final LocalDateTime data = LocalDateTime.now();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "voto_id")
    private Sessao sessao;

}

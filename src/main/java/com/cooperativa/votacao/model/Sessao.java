package com.cooperativa.votacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Sessao extends BaseId{

    private boolean status;

    @OneToMany
    private List<Voto> votos;

    @OneToOne
    private ItemVotacao itemVotacao;
}

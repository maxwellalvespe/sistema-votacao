package com.cooperativa.votacao.model;

import com.cooperativa.votacao.repository.SessaoRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ItemVotacao extends BaseId{

    private String descricao;


    @OneToOne
    private Sessao sessao;
}

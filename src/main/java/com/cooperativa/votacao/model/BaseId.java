package com.cooperativa.votacao.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseId {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}

package com.cooperativa.votacao.repository;

import com.cooperativa.votacao.model.BaseId;
import com.cooperativa.votacao.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, BaseId> {
}

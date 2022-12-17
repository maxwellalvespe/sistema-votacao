package com.cooperativa.votacao.config.exception;

public class UsuarioJaCadastradoNessaSessao extends RuntimeException {

    public UsuarioJaCadastradoNessaSessao(){
        super("Usuário já se cadastrou para essa sessão");
    }
}

package com.cooperativa.votacao.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ UsuarioJaCadastradoNessaSessao.class })
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleConflict(Exception ex) {

        ErrorMessage re = new ErrorMessage(HttpStatus.CONFLICT,
                ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(re);
    }

    @ExceptionHandler({ RuntimeException.class })
    @ResponseBody
    public ResponseEntity<ErrorMessage> noSouchFieldException(Exception ex) {

        ErrorMessage re = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(re);
    }
}

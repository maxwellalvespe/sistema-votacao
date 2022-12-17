package com.cooperativa.votacao.config.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class ErrorMessage {

    private HttpStatus httpStatus;
    private String message;



}

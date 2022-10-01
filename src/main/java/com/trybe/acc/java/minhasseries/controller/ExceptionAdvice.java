package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.exception.DataError;
import com.trybe.acc.java.minhasseries.exception.SerieExistenteException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
  @ExceptionHandler({SerieExistenteException.class})
  @ResponseStatus(HttpStatus.CONFLICT)
  public DataError handleRecursoExistente(RuntimeException e) {
    return new DataError(e.getMessage());
  }
}

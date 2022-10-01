package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.exception.DataError;
import com.trybe.acc.java.minhasseries.exception.EpisodioExistenteException;
import com.trybe.acc.java.minhasseries.exception.ErroInesperadoException;
import com.trybe.acc.java.minhasseries.exception.SerieExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieNaoEncontradaException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
  @ExceptionHandler({SerieExistenteException.class, EpisodioExistenteException.class})
  @ResponseStatus(HttpStatus.CONFLICT)
  public DataError handleRecursoExistente(RuntimeException e) {
    return new DataError(e.getMessage());
  }

  @ExceptionHandler({SerieNaoEncontradaException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public DataError handleSerieNaoEncontrada(RuntimeException e) {
    return new DataError(e.getMessage());
  }

  @ExceptionHandler({ErroInesperadoException.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public DataError handleErroInesperado(RuntimeException e) {
    return new DataError(e.getMessage());
  }
}

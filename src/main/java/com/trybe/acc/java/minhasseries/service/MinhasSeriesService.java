package com.trybe.acc.java.minhasseries.service;

import com.trybe.acc.java.minhasseries.exception.SerieExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieNaoEncontradaException;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.repository.SerieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MinhasSeriesService {
  @Autowired
  private SerieRepository serieRepository;

  public List<Serie> listar() {
    return serieRepository.findAll();
  }

  /** save serie method.*/
  public Serie salvarUmaSerie(Serie serie) {
    if (serieRepository.existsByNome(serie.getNome())) {
      throw new SerieExistenteException();
    }

    return serieRepository.save(serie);
  }

  /** delete serie method.*/
  public void apagarSeriePorId(Integer id) {
    if (serieRepository.existsById(id)) {
      serieRepository.deleteById(id);
      return;
    }

    throw new SerieNaoEncontradaException();
  }
}

package com.trybe.acc.java.minhasseries.service;

import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.repository.SerieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MinhasSeriesService {
  @Autowired
  private SerieRepository serieRepository;

  public List<Serie> list() {
    return serieRepository.findAll();
  }
}
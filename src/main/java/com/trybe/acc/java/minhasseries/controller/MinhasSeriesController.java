package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.service.MinhasSeriesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/series")
public class MinhasSeriesController {
  @Autowired
  private MinhasSeriesService minhasSeriesService;

  @GetMapping
  public List<Serie> listar() {
    return minhasSeriesService.listar();
  }

  @PostMapping
  public Serie salvarUmaSerie(@RequestBody Serie serie) {
    return minhasSeriesService.salvarUmaSerie(serie);
  }

  @DeleteMapping("/{id}")
  public void apagarSeriePorId(@PathVariable("id") Integer id) {
    minhasSeriesService.apagarSeriePorId(id);
  }

  @PostMapping("/{id}/episodios")
  public Serie addEpisodio(@PathVariable Integer id, @RequestBody Episodio episodio) {
    return minhasSeriesService.adicionarEpisodio(id, episodio);
  }
}

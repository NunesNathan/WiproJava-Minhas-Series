package com.trybe.acc.java.minhasseries.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Serie {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
  private List<Episodio> episodios = new ArrayList<>();

  public Serie() {
  }

  public Serie(String nome) {
    this.nome = nome;
  }

  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Episodio> getEpisodios() {
    return episodios;
  }

  public void adicionarEpisodio(Episodio episodios) {
    this.episodios.add(episodios);
  }
}

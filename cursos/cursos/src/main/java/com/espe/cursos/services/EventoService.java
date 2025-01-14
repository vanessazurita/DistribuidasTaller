package com.espe.cursos.services;

import com.espe.cursos.models.entities.Evento;

import java.util.List;
import java.util.Optional;

public interface EventoService {

    List<Evento> findAll();
    Optional<Evento> findById(Integer id);
    Evento save(Evento evento);
    void deleteById(Integer id);

}

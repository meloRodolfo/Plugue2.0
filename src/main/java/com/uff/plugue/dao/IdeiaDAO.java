package com.uff.plugue.dao;

import java.util.List;

import com.uff.plugue.model.Ideia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeiaDAO extends JpaRepository<Ideia, Integer>{
    List<Ideia> findByTitulo(String titulo);
    List<Ideia> findByAreaInteresse(String areaInteresse);
    List<Ideia> findByAreaInteresseAndTitulo(String areaInteresse, String titulo);
}

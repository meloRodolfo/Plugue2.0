package com.uff.plugue.dao;

import java.util.List;

import com.uff.plugue.model.Projeto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoDAO extends JpaRepository<Projeto, Integer>{

    List<Projeto> findByTitulo(String titulo);
    List<Projeto> findByAreaInteresse(String areaInteresse);
    List<Projeto> findByTituloAndAreaInteresse(String titulo, String areaInteresse);
    
}

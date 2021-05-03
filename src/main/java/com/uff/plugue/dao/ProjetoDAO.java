package com.uff.plugue.dao;

import java.util.List;
import java.util.Optional;

import com.uff.plugue.model.Professor;
import com.uff.plugue.model.Projeto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoDAO extends JpaRepository<Projeto, Integer>{

    List<Projeto> findByTitulo(String titulo);
    List<Projeto> findByAreaInteresse(String areaInteresse);
    List<Projeto> findByTituloAndAreaInteresse(String titulo, String areaInteresse);
    Optional<Projeto> findByAreaInteresseAndTitulo(String titulo, String areaInteresse);
    Projeto findById(int id);
    List<Projeto> findByProfessor(Professor professor);
}

package com.uff.plugue.dao;

import java.util.List;
import java.util.Optional;

import com.uff.plugue.model.Aluno;
import com.uff.plugue.model.Ideia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeiaDAO extends JpaRepository<Ideia, Integer>{
    
    List<Ideia> findByTitulo(String titulo);
    List<Ideia> findByAreaInteresse(String areaInteresse);
    List<Ideia> findByAreaInteresseAndTitulo(String areaInteresse, String titulo);

    // @Query(value = "SELECT * FROM \"Ideia\" where aluno_id = :aluno_id", nativeQuery = true)
    List<Ideia> findByAluno_Id(Integer aluno);
    Ideia findById(int id);
    List<Ideia> findByAluno(Aluno aluno);
}

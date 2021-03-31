package com.uff.plugue.dao;

import com.uff.plugue.model.Professor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorDAO extends JpaRepository<Professor, Integer> {
    
    @Query(value = "SELECT * FROM Usuario u WHERE u.contato = :contato AND u.senha = :senha", nativeQuery = true)
    boolean findByContato(String contato, String senha);
}

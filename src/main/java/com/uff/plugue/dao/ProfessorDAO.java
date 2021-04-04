package com.uff.plugue.dao;

import com.uff.plugue.model.Professor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorDAO extends JpaRepository<Professor, Integer> {
    
    Professor findByContatoAndSenha(String contato, String senha);
}

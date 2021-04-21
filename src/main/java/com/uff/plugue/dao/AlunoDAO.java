package com.uff.plugue.dao;

import java.util.Optional;

import com.uff.plugue.model.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 

@Repository
public interface AlunoDAO extends JpaRepository<Aluno, Integer> {

    Optional<Aluno> findByContato(String contato);
}

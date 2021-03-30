package com.uff.plugue.dao;

import com.uff.plugue.model.Projeto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoDAO extends JpaRepository<Projeto, Integer>{
    
}

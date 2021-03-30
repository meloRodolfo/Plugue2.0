package com.uff.plugue.dao;

import com.uff.plugue.model.Ideia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeiaDAO extends JpaRepository<Ideia, Integer>{
    
}

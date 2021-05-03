package com.uff.plugue.dao;

import java.util.Optional;

import com.uff.plugue.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{
    
    Optional<Usuario> findByContato(String contato); 
}

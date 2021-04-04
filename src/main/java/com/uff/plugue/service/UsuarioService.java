package com.uff.plugue.service;

import java.util.Optional;

import javax.naming.AuthenticationException;

import com.uff.plugue.dao.AlunoDAO;
import com.uff.plugue.dao.ProfessorDAO;
import com.uff.plugue.dao.UsuarioDAO;
import com.uff.plugue.model.Aluno;
import com.uff.plugue.model.Professor;
import com.uff.plugue.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioDAO dao;

    public Usuario login(String login, String senha) throws AuthenticationException {
        Optional<Usuario> usuario = dao.findByContato(login);
        if(usuario.get().getSenha().equals(senha)) {
            return usuario.get();
        } else {
            throw new AuthenticationException();
        }
    }
}

package com.uff.plugue.service;

import java.util.Optional;

import javax.naming.AuthenticationException;

import com.uff.plugue.dao.UsuarioDAO;
import com.uff.plugue.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioDAO dao;

    public Usuario login(@RequestParam String login, @RequestParam String senha) throws AuthenticationException {
        Optional<Usuario> usuario = dao.findByContato(login);
        if(usuario.get().getSenha().equals(senha)) {
            return usuario.get();
        } else {
            throw new AuthenticationException();
        }
    }

    public String resetSenha(int id, String senha) {
        Optional<Usuario> usuario = dao.findById(id);
        usuario.get().setSenha(senha);
        dao.save(usuario.get());
        return "Senha atualizada com sucesso";
    }

    public String deleteUsuario(int id) {
        dao.deleteById(id);
        return "Usuário deletado com sucesso";
    }
    
}

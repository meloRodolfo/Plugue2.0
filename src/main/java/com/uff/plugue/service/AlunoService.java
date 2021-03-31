package com.uff.plugue.service;

import java.util.Optional;

import com.uff.plugue.dao.AlunoDAO;
import com.uff.plugue.model.Aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    
    @Autowired
    private AlunoDAO dao;

    public void addAluno(Aluno aluno) {
        dao.save(aluno);
    }

    public void updateAluno(int id, Aluno aluno) {
        aluno.setId(id);
        dao.save(aluno);
    }

    public Optional<Aluno> getAluno(int id) {
        return dao.findById(id);
    }

    public void deleteAluno(int id) {
        dao.deleteById(id);
    }

    public void login(String login, String senha) {
        
    }

    public void logout() {}

    public void resetarSenha() {}

    public void interessar() {}
}

package com.uff.plugue.service;

import java.util.Optional;

import com.uff.plugue.dao.ProfessorDAO;
import com.uff.plugue.model.Professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorDAO dao;

    public boolean addProfessor(Professor professor) {
        if (professor != null) {
            dao.save(professor);
            return true;
        }
        return false;

    }

    public boolean updateProfessor(int id, Professor professor) {
        if (id != 0 && professor != null) {
            professor.setId(id);
            dao.save(professor);
            return true;
        }
        return false;

    }

    public Optional<Professor> getProfessor(Integer id) {
        return dao.findById(id);
    }

    public void deleteProfessor(Integer id) {
        dao.deleteById(id);
    }

    public boolean login(String login, String senha) {

        return dao.findByContato(login, senha);
    }

    public boolean logout(Professor professor) {
        return true;
    }

    public void interessar() {

    }

    public void resetSenha(Integer id, String novaSenha) {
        Optional<Professor> prof = dao.findById(id);
        prof.get().setSenha(novaSenha);
    }
}

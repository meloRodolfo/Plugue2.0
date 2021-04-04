package com.uff.plugue.service;

import java.util.Optional;

import com.uff.plugue.dao.IdeiaDAO;
import com.uff.plugue.dao.ProfessorDAO;
import com.uff.plugue.model.Ideia;
import com.uff.plugue.model.Professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorDAO dao;

    @Autowired
    private IdeiaDAO ideiaDao;

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

    public Professor login(String login, String senha) {
        return dao.findByContatoAndSenha(login, senha);
    }

    public Professor interessar(int idIdeia, int idProfessor) {
        Optional<Professor> prof = dao.findById(idProfessor);
        Optional<Ideia> ideia = ideiaDao.findById(idIdeia);

        prof.get().setIdeias(ideia.get());
        dao.save(prof.get());
        dao.flush();
        return dao.findById(idProfessor).get();
    }

}

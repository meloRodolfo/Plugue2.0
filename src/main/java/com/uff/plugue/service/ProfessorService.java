package com.uff.plugue.service;

import java.util.List;
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

    public Professor addProfessor(Professor professor) {
        dao.save(professor);
        return dao.findById(professor.getId());
    }

    public Professor updateProfessor(int id, Professor professor) {
        professor.setId(id);
        dao.save(professor);
        return dao.findById(id);

    }

    public Professor getProfessor(int id) {
        return dao.findById(id);
    }

    public Ideia interessar(int idIdeia, int idProfessor) {
        Professor professor = dao.findById(idProfessor);
        Ideia ideia = ideiaDao.findById(idIdeia);

        Ideia ideiaInteresse = ideia;
        ideiaInteresse.setProfessor(professor);
        ideiaDao.save(ideiaInteresse);
        return ideia;
    }

    public List<Ideia> retornarInteresses(int id) {
        Professor professor = dao.findById(id);
        return professor.getIdeias();
    }

}

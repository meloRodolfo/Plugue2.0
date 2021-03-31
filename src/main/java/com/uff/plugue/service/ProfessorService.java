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

    public void addProfessor(Professor professor) {
        dao.save(professor);
    }

    public void updateProfessor(int id, Professor professor) {
        professor.setId(id);
        dao.save(professor);
    }

    public Optional<Professor> getProfessor(Integer id) {
        return dao.findById(id);
    }

    public void deleteProfessor(Integer id) {
        dao.deleteById(id);
    }
}

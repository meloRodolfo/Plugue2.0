package com.uff.plugue.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.uff.plugue.dao.AlunoDAO;
import com.uff.plugue.dao.ProjetoDAO;
import com.uff.plugue.model.Aluno;
import com.uff.plugue.model.Projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    
    @Autowired
    private AlunoDAO dao;

    @Autowired
    private ProjetoDAO projetoDao;

    public Aluno addAluno(Aluno aluno) {
        dao.save(aluno);
        return dao.findById(aluno.getId());
    }

    public Aluno updateAluno(int id, Aluno aluno) {
        aluno.setId(id);
        dao.save(aluno);
        return dao.findById(id);
    }

    public Aluno getAluno(int id) {
        return dao.findById(id);
    }

    public Aluno interessar(int idProjeto, int idAluno) {
        Projeto projeto = projetoDao.findById(idProjeto);
        Aluno aluno = dao.findById(idAluno);

        Projeto proj = projeto;
        proj.setAluno(aluno);
        projetoDao.save(proj);
        return aluno;
    }

}

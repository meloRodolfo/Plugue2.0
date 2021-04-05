package com.uff.plugue.service;

import java.util.Optional;

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

    public void interessar(int idProjeto, int idAluno) {
        Optional<Projeto> projeto = projetoDao.findById(idProjeto);
        Optional<Aluno> aluno = dao.findById(idAluno);

        Projeto proj = projeto.get();
        proj.setAluno(aluno.get());
        projetoDao.save(proj);
    }
}

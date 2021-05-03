package com.uff.plugue.service;

import java.util.List;
import java.util.Optional;

import com.uff.plugue.dao.AlunoDAO;
import com.uff.plugue.dao.IdeiaDAO;
import com.uff.plugue.model.Aluno;
import com.uff.plugue.model.Ideia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdeiaService {

    @Autowired
    private IdeiaDAO dao;

    @Autowired
    private AlunoDAO daoAluno;

    public Optional<Ideia> addIdeia(Ideia ideia) {
        dao.save(ideia);
        return dao.findById(ideia.getId());
    }

    public Optional<Ideia> updateIdeia(int id, Ideia ideia){
        ideia.setId(id);
        dao.save(ideia);
        return dao.findById(id);
    }

    public Optional<Ideia> getIdeia(int id) {
        return dao.findById(id);
    }

    public List<Ideia> getIdeias() {
        return dao.findAll();
    }

    public List<Ideia> getIdeiaPorParametros(String areaInteresse, String titulo, String idAluno) {
        if (titulo != null && areaInteresse != null) return dao.findByAreaInteresseAndTitulo(areaInteresse, titulo);
        else if(titulo != null) return dao.findByTitulo(titulo);
        else if(idAluno != null) {
            Aluno aluno = daoAluno.findById(Integer.parseInt(idAluno)).get();
            return dao.findByAluno_Id(aluno.getId());
        }
        else return dao.findByAreaInteresse(areaInteresse);
    }

    public String deleteIdeia(Integer id) {
        dao.deleteById(id);
        return "Ideia deletada com sucesso";
    }
}

package com.uff.plugue.service;

import java.util.List;

import com.uff.plugue.dao.ProfessorDAO;
import com.uff.plugue.dao.ProjetoDAO;
import com.uff.plugue.model.Professor;
import com.uff.plugue.model.Projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetoService {
    
    @Autowired
    private ProjetoDAO dao;

    @Autowired
    private ProfessorDAO professorDao;

    public Projeto addProjeto(Projeto projeto) {
            dao.save(projeto);
            return dao.findById(projeto.getId());
        
    }

    public Projeto updateProjeto(int id, Projeto projeto) {
            projeto.setId(id);
            dao.save(projeto);
            return dao.findById(id);
    }

    public Projeto getProjeto(int id) {
        return dao.findById(id);
    }

    public String deleteProjeto(int id) {
        dao.deleteById(id);
        return "Apagado com sucesso";
    }

    public List<Projeto> listarProjetos() {

        return dao.findAll();
    }

    public List<Projeto> buscaProjetoPorTitulo(String titulo) {
        return dao.findByTitulo(titulo);
    }

    public List<Projeto> buscaProjetoPorArea(String areaInteresse) {
        return dao.findByAreaInteresse(areaInteresse);
    }

    public List<Projeto> buscaProjetoPorTituloArea(String titulo, String areaInteresse) {
        return dao.findByTituloAndAreaInteresse(titulo, areaInteresse);
    } 
    
    public List<Projeto> buscaProjetoPorProfessor(String id) {
        Professor professor = new Professor();
        professor = professorDao.findById(Integer.parseInt(id));
        return dao.findByProfessor(professor);
    }
}

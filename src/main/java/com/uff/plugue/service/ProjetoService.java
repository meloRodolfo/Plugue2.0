package com.uff.plugue.service;

import java.util.List;
import java.util.Optional;

import com.uff.plugue.dao.ProjetoDAO;
import com.uff.plugue.model.Projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetoService {
    
    @Autowired
    private ProjetoDAO dao;

    public boolean addProjeto(Projeto projeto) {
        if(projeto != null) {
            dao.save(projeto);
            return true;
        }
        return false;
        
    }

    public boolean updateProjeto(int id, Projeto projeto) {
        if(id != 0 && projeto != null) {
            projeto.setId(id);
            dao.save(projeto);
            return true;
        }
        return false;
    }

    public Optional<Projeto> getProjeto(int id) {
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
}

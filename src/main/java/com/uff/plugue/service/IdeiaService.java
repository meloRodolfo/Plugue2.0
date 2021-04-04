package com.uff.plugue.service;

import java.util.List;
import java.util.Optional;

import com.uff.plugue.dao.IdeiaDAO;
import com.uff.plugue.model.Ideia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdeiaService {

    @Autowired
    private IdeiaDAO dao;

    public void addIdeia(Ideia ideia) {
        dao.save(ideia);
    }

    public void updateIdeia(int id, Ideia ideia){
        ideia.setId(id);
        dao.save(ideia);
    }

    public List<Ideia> getIdeias() {
        return dao.findAll();
    }

    public List<Ideia> getIdeiaPorParametros(String areaInteresse, String titulo) {
        if(titulo != null && areaInteresse != null) return dao.findByAreaInteresseAndTitulo(areaInteresse, titulo);
        else if(titulo != null) return dao.findByTitulo(titulo);
        else return dao.findByAreaInteresse(areaInteresse);
    }

    public void deleteIdeia(Integer id) {
        dao.deleteById(id);
    }
}

package com.uff.plugue.service;

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

    public Optional<Ideia> getIdeia(Integer id) {
        return dao.findById(id);
    }

    public void deleteIdeia(Integer id) {
        dao.deleteById(id);
    }
}

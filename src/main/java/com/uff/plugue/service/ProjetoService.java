package com.uff.plugue.service;

import java.util.Optional;

import com.uff.plugue.dao.ProjetoDAO;
import com.uff.plugue.model.Projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetoService {
    
    @Autowired
    private ProjetoDAO dao;

    public void addProjeto(Projeto projeto) {
        dao.save(projeto);
    }

    public void updateProjeto(Long id, Projeto projeto) {
        projeto.setId(id);
        dao.save(projeto);
    }

    public Optional<Projeto> getProjeto(int id) {
        return dao.findById(id);
    }

    public void deleteProjeto(int id) {
        dao.deleteById(id);
    }
}

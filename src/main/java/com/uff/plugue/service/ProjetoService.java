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

    public boolean updateProjeto(Long id, Projeto projeto) {
        if(id != null && projeto != null) {
            projeto.setId(id);
            dao.save(projeto);
            return true;
        }
        return false;
    }

    public Optional<Projeto> getProjeto(Integer id) {
        return dao.findById(id);
    }

    public void deleteProjeto(Integer id) {
        dao.deleteById(id);
    }

    public List<Projeto> listarProjetos() {

        return dao.findAll();
    }
}

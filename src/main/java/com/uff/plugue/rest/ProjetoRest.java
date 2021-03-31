package com.uff.plugue.rest;

import java.util.List;
import java.util.Optional;

import com.uff.plugue.model.Projeto;
import com.uff.plugue.service.ProjetoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projeto")
public class ProjetoRest {

    @Autowired
    ProjetoService projetoService = new ProjetoService();

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean novoProjeto(Projeto projeto) {
        return projetoService.addProjeto(projeto);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean atualizaProjeto(@PathVariable("id") Long id, Projeto projeto) {

        return projetoService.updateProjeto(id, projeto);
    }

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Projeto> buscaProjeto(@PathVariable Integer id) {
        return projetoService.getProjeto(id);
    }

    @DeleteMapping(path = { "/{id}" }, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void excluiProjeto(@PathVariable Integer id) {
        projetoService.deleteProjeto(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Projeto> listaProjetos() {

        return projetoService.listarProjetos();
    }
}

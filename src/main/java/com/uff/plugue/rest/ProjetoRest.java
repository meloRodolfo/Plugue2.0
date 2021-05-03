package com.uff.plugue.rest;

import java.util.ArrayList;
import java.util.List;

import com.uff.plugue.model.Projeto;
import com.uff.plugue.service.ProjetoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:4200")
@RequestMapping("/projeto")
@Api(value = "Projeto")
public class ProjetoRest {

    @Autowired
    ProjetoService projetoService = new ProjetoService();

    @PostMapping
    @ApiOperation(value = "Novo projeto")
    public Projeto novoProjeto(@RequestBody Projeto projeto) {
        return projetoService.addProjeto(projeto);
    }

    @PutMapping(path = {"/{id}"})
    @ApiOperation(value = "Atualiza projeto")
    public Projeto atualizaProjeto(@PathVariable("id") int id, @RequestBody Projeto projeto) {
        return projetoService.updateProjeto(id, projeto);
    }

    @GetMapping(path = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "busca projeto")
    public Projeto buscaProjeto(@PathVariable int id) {
        return projetoService.getProjeto(id);
    }

    @DeleteMapping(path = { "/{id}" })
    @ApiOperation(value = "Exclui projeto")
    public String excluiProjeto(@PathVariable int id) {
        return projetoService.deleteProjeto(id);
    }

    @GetMapping
    @ApiOperation(value = "Lista projetos")
    public List<Projeto> listaProjetos(@RequestParam(required = false) String titulo, 
                                       @RequestParam(required = false) String areaInteresse) {
        List<Projeto> projetos = new ArrayList<>();
        if(titulo != null && areaInteresse != null) {
            projetos.addAll(projetoService.buscaProjetoPorTituloArea(titulo, areaInteresse)) ;
        } else if(titulo != null) {
            projetos.addAll(projetoService.buscaProjetoPorTitulo(titulo));
        } else if(areaInteresse != null){
            projetos.addAll(projetoService.buscaProjetoPorArea(areaInteresse));
        } else {
            projetos.addAll(projetoService.listarProjetos());
        }

        return projetos;
    }
}

package com.uff.plugue.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.uff.plugue.model.Ideia;
import com.uff.plugue.service.IdeiaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
@RequestMapping("/ideia")
@Api(value = "Aluno")
public class IdeiaRest {

    @Autowired
    private IdeiaService ideiaService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Nova ideia")
    public void salvar(@RequestBody Ideia ideia) {
        ideiaService.addIdeia(ideia);
    }

    @PutMapping(path ={"/{id}"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Atualiza ideia")
    public void atualizar(@PathVariable("id") int id, @RequestBody Ideia ideia) {
        ideiaService.updateIdeia(id, ideia);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Lista ideias")
    public List<Ideia> listaIdeias (@RequestParam(required = false) String titulo, @RequestParam(required = false) String areaInteresse){  
        List<Ideia> ideias = new ArrayList<Ideia>();
        ideias.addAll(ideiaService.getIdeiaPorParametros(areaInteresse, titulo));

        if(titulo == null && areaInteresse == null) return ideiaService.getIdeias();
        return ideias;      
    }

    @DeleteMapping(path ={"/{id}"})
    @ApiOperation(value = "Exclui ideia")
    public void deletar (@PathVariable("id") int id){
        ideiaService.deleteIdeia(id);
    }
}
    

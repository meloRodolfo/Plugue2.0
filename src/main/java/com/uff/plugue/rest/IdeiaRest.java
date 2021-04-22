package com.uff.plugue.rest;

import java.util.ArrayList;
import java.util.List;

import com.uff.plugue.model.Ideia;
import com.uff.plugue.service.IdeiaService;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/ideia")
@Api(value = "Aluno")
@CrossOrigin(origins = "http://127.0.0.1:4200")
public class IdeiaRest {

    @Autowired
    private IdeiaService ideiaService;

    @PostMapping
    @ApiOperation(value = "Cria uma nova ideia")
    public Ideia salvar(@RequestBody Ideia ideia) {
        return ideiaService.addIdeia(ideia);
    }

    @PutMapping(path ={"/{id}"})
    @ApiOperation(value = "Atualiza uma ideia")
    public Ideia atualizar(@PathVariable("id") int id, @RequestBody Ideia ideia) {
        return ideiaService.updateIdeia(id, ideia);
    }

    @GetMapping
    @ApiOperation(value = "Lista ideias")
    public List<Ideia> listaIdeias (
        @RequestParam(required = false) String titulo, 
        @RequestParam(required = false) String areaInteresse
    ){  
        List<Ideia> ideias = new ArrayList<Ideia>();
        ideias.addAll(ideiaService.getIdeiaPorParametros(areaInteresse, titulo));

        if(titulo == null && areaInteresse == null) return ideiaService.getIdeias();
        return ideias;      
    }

    @DeleteMapping(path ={"/{id}"})
    @ApiOperation(value = "Exclui uma ideia")
    public String deletar (@PathVariable("id") int id){
        return ideiaService.deleteIdeia(id);
    }
}
    

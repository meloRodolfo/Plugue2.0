package com.uff.plugue.rest;

import java.util.Optional;

import com.uff.plugue.model.Ideia;
import com.uff.plugue.service.IdeiaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ideia")
public class IdeiaRest {

    @Autowired
    private IdeiaService ideiaService;

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void salvar(@RequestBody Ideia ideia) {
        ideiaService.addIdeia(ideia);
    }

    @PutMapping(path ={"/{id}"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void atualizar(@PathVariable("id") int id, @RequestBody Ideia ideia) {
        ideiaService.updateIdeia(id, ideia);
    }

    @GetMapping(path = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Ideia> busca (@PathVariable("id") int id){        
        return ideiaService.getIdeia(id);
    }

    @DeleteMapping(path ={"/{id}"})
    public void deletar (@PathVariable("id") int id){
        ideiaService.deleteIdeia(id);
    }
}
    

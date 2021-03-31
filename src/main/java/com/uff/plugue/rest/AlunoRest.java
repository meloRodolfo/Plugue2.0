package com.uff.plugue.rest;

import java.util.Optional;


import com.uff.plugue.model.Aluno;
import com.uff.plugue.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;


@RestController
@RequestMapping("/aluno")
public class AlunoRest {

    @Autowired
    private AlunoService alunoService;       
    
    @GetMapping(path = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Aluno> busca (@PathVariable("id") int id){        
        return alunoService.getAluno(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void salvar(@RequestBody Aluno aluno) {
        alunoService.addAluno(aluno);
    }
    
    @PutMapping(path ={"/{id}"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void atualizar(@PathVariable("id") long id, @RequestBody Aluno aluno) {
        alunoService.updateAluno(id, aluno);
    }

    @DeleteMapping(path ={"/{id}"})
    public void deletar (@PathVariable("id") int id){
        alunoService.deleteAluno(id);
    }
}
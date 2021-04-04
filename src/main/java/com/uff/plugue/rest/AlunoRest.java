package com.uff.plugue.rest;

import java.util.Optional;

import com.uff.plugue.model.Aluno;
import com.uff.plugue.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.http.MediaType;


@RestController
@RequestMapping("/aluno")
@Api(value = "Aluno")
public class AlunoRest {

    @Autowired
    private AlunoService alunoService;  
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Salva aluno")
    public void salvar(@RequestBody Aluno aluno) {
        alunoService.addAluno(aluno);
    }

    @DeleteMapping(path ={"/{id}"})
    @ApiOperation(value = "Exclui aluno")
    public void deletar (@PathVariable("id") int id){
        alunoService.deleteAluno(id);
    }
    
    @GetMapping(path = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Busca aluno")
    public Optional<Aluno> busca (@PathVariable("id") int id){        
        return alunoService.getAluno(id);
    }    
    
    @PutMapping(path ={"/{id}"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Atualiza aluno")
    public void atualizar(@PathVariable("id") int id, @RequestBody Aluno aluno) {
        alunoService.updateAluno(id, aluno);
    }

    @PutMapping(path = {"/{idProjeto}/{idAluno}"})
    @ApiOperation(value = "Interesse aluno")
    public Aluno interessar(@PathVariable("idProjeto") int idProjeto, @PathVariable("idAluno") int idAluno) {
        return null;
    }

    
}

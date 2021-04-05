package com.uff.plugue.rest;

import java.util.Optional;

import com.uff.plugue.model.Aluno;
import com.uff.plugue.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/aluno")
@Api(value = "Aluno")
public class AlunoRest {

    @Autowired
    private AlunoService alunoService;  
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Salva um aluno")
    public void salvar(@RequestBody Aluno aluno) {
        alunoService.addAluno(aluno);
    }
    
    @GetMapping(path = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Busca um aluno")
    public Optional<Aluno> busca (@PathVariable("id") int id){        
        return alunoService.getAluno(id);
    }    
    
    @PutMapping(path ={"/{id}"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Atualiza um aluno")
    public void atualizar(@PathVariable("id") int id, @RequestBody Aluno aluno) {
        alunoService.updateAluno(id, aluno);
    }

    @PutMapping(path = {"/{idAluno}/projeto/{idProjeto}"})
    @ApiOperation(value = "Informa interesse de aluno em um projeto")
    public void interessar(@PathVariable("idAluno") int idAluno, @PathVariable("idProjeto") int idProjeto) {
        alunoService.interessar(idProjeto, idAluno);
    }
}

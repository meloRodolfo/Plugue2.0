package com.uff.plugue.rest;

import java.util.List;

import com.uff.plugue.model.Aluno;
import com.uff.plugue.model.Projeto;
import com.uff.plugue.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://127.0.0.1:4200")
@RequestMapping("/aluno")
@Api(value = "Aluno")
public class AlunoRest {

    @Autowired
    private AlunoService alunoService;  
    
    @PostMapping
    @ApiOperation(value = "Salva um aluno")
    public Aluno salvar(@RequestBody Aluno aluno) {
        return alunoService.addAluno(aluno);
    }
    
    @GetMapping(path = {"/{id}"})
    @ApiOperation(value = "Busca um aluno")
    public Aluno busca (@PathVariable("id") int id){        
        return alunoService.getAluno(id);
    }    
    
    @PutMapping(path ={"/{id}"})
    @ApiOperation(value = "Atualiza um aluno")
    public Aluno atualizar(@PathVariable("id") int id, @RequestBody Aluno aluno) {
        return alunoService.updateAluno(id, aluno);
    }

    @PutMapping(path = {"/{idAluno}/projeto/{idProjeto}"})
    @ApiOperation(value = "Informa interesse de aluno em um projeto")
    public Aluno interessar(@PathVariable("idAluno") int idAluno, @PathVariable("idProjeto") int idProjeto) {
        return alunoService.interessar(idProjeto, idAluno);
    }

    @GetMapping(path = {"/{id}/projetos"})
    @ApiOperation(value = "Retorna projetos de interesse de um aluno")
    public List<Projeto> listarInteresses(@PathVariable("id") int id) {
        return alunoService.retornarInteresses(id);
    }
}

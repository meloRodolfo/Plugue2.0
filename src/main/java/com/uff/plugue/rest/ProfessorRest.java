package com.uff.plugue.rest;

import java.util.Optional;

import com.uff.plugue.model.Professor;
import com.uff.plugue.service.ProfessorService;

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
@RequestMapping("/professor")
@Api(value = "Professor")
public class ProfessorRest {

    @Autowired
    ProfessorService professorService = new ProfessorService();

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Novo professor")
    public boolean novoProfessor(@RequestBody Professor professor) {
        
        return professorService.addProfessor(professor);
    }

    @PutMapping(path = {"/{id}"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Atualiza um professor")
    public boolean atualizaProfessor( @PathVariable("id") int id, @RequestBody Professor professor) {

        return professorService.updateProfessor(id, professor);
    }

    @GetMapping(path = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Busca por um professor")
    public Optional<Professor> buscaProfessor(@PathVariable("id") Integer id){
        return professorService.getProfessor(id);
    }

    @PutMapping(path = {"/{idProfessor}/ideia/{idIdeia}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Informa interesse de professor em uma ideia")
    public void interessar(@PathVariable("idIdeia") int idIdeia, @PathVariable("idProfessor") int idProfessor) {
        professorService.interessar(idIdeia, idProfessor);
    }

}

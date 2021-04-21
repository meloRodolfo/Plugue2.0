package com.uff.plugue.rest;

import com.uff.plugue.model.Ideia;
import com.uff.plugue.model.Professor;
import com.uff.plugue.service.ProfessorService;

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
@RequestMapping("/professor")
@Api(value = "Professor")
public class ProfessorRest {

    @Autowired
    ProfessorService professorService = new ProfessorService();

    @PostMapping
    @ApiOperation(value = "Novo professor")
    public Professor novoProfessor(@RequestBody Professor professor) {
        
        return professorService.addProfessor(professor);
    }

    @PutMapping(path = {"/{id}"})
    @ApiOperation(value = "Atualiza um professor")
    public Professor atualizaProfessor(@PathVariable("id") int id, @RequestBody Professor professor) {

        return professorService.updateProfessor(id, professor);
    }

    @GetMapping(path = {"/{id}"})
    @ApiOperation(value = "Busca por um professor")
    public Professor buscaProfessor(@PathVariable("id") Integer id){
        
        return professorService.getProfessor(id);
    }

    @PutMapping(path = {"/{idProfessor}/ideia/{idIdeia}"})
    @ApiOperation(value = "Informa interesse de professor em uma ideia")
    public Ideia interessar(@PathVariable("idIdeia") int idIdeia, @PathVariable("idProfessor") int idProfessor) {
        return professorService.interessar(idIdeia, idProfessor);
    }

}

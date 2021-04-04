package com.uff.plugue.rest;

import java.util.Optional;

import com.uff.plugue.model.Ideia;
import com.uff.plugue.model.Professor;
import com.uff.plugue.service.ProfessorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

@RestController
@RequestMapping("/professor")
@Api(value = "Professor")
public class ProfessorRest {

    @Autowired
    ProfessorService professorService = new ProfessorService();

    /*@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Novo professor")
    public boolean novoProfessor(@RequestBody Professor professor) {
        
        return professorService.addProfessor(professor);
    }*/

    @PutMapping(path = {"/{id}"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Atualiza professor")
    public boolean atualizaProfessor( @PathVariable("id") int id, @RequestBody Professor professor) {

        return professorService.updateProfessor(id, professor);
    }

    @GetMapping(path = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Busca professor")
    public Optional<Professor> buscaProfessor(@PathVariable("id") Integer id){
        return professorService.getProfessor(id);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Exclui professor")
    public String excluiProfessor(@PathVariable("id") Integer id){
        return professorService.deleteProfessor(id);
    }

    /*@GetMapping(path = {"/{login}/{senha}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Professor loginProfessor(@PathVariable("login") String login, @PathVariable("senha") String senha) {

        return professorService.login(login, senha);
    }*/

    @PutMapping(path = {"/{idIdeia}/{idProfessor}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Interesse professor")
    public Professor interessar(@PathVariable("idIdeia") int idIdeia, @PathVariable("idProfessor") int idProfessor) {
        return professorService.interessar(idIdeia, idProfessor);
    }

    /*@PutMapping(value = "/{id}/{senha}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Alterar senha")
    public void alteraSenha(Integer id, String senha) {
        professorService.resetSenha(id, senha);
    }*/

}
